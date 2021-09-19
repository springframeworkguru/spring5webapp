package guru.springframework.spring5webapp.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isbn;


  @ManyToMany
  @JoinTable(name = "authors_book", joinColumns = @JoinColumn(name = "book_id"),
  inverseJoinColumns = @JoinColumn(name = "authors_id"))
  private Set<Author> authors;

  public Book() {
  }

  public Book(String title, Set<Author> authors, String isbn) {
    this.title = title;
    this.authors = authors;
    this.isbn = isbn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", authors=" + authors +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
