package guru.springframework.spring5webapp.domain;

import java.util.Set;

public class Book {
    private String author;
    private String isbn;
    private Set<Author> authors;

    public Book() {
    }

    public Book(String author, String isbn, Set<Author> authors) {
        this.author = author;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
