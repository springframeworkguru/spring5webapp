package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authorSet;

    public Book() {
    }

    public Book(final String title, final String isbn, final Set<Author> authorSet) {
        this.title = title;
        this.isbn = isbn;
        this.authorSet = authorSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthorSet() {
        return this.authorSet;
    }

    public void setAuthorSet(final Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Book book = (Book) o;
        return Objects.equals(this.id, book.id);
    }

    @Override
    public int hashCode() {
        return this.id == 0
               ? 0
               : this.id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(this.id);
        sb.append(", title='").append(this.title).append('\'');
        sb.append(", isbn='").append(this.isbn).append('\'');
        sb.append(", authorSet=").append(this.authorSet);
        sb.append('}');
        return sb.toString();
    }
}
