package guru.springframework.spring5webapp.domain;


import javax.persistence.*;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public long id;

    private String firstName;
    private String lastName;
    @ManyToMany
    private Set<Books> books;

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Author(String firstName, String lastName, Set<Books> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
