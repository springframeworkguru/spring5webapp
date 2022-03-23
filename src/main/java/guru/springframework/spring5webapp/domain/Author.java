package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> bookSet;

    public Author() {
    }

    public Author(final String firstName, final String lastName, final Set<Book> bookSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookSet = bookSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBookSet() {
        return this.bookSet;
    }

    public void setBookSet(final Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Author author = (Author) o;
        return Objects.equals(this.id, author.id);
    }

    @Override
    public int hashCode() {
        return this.id == null
               ? 0
               : this.id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(this.id);
        sb.append(", firstName='").append(this.firstName).append('\'');
        sb.append(", lastName='").append(this.lastName).append('\'');
        sb.append(", bookSet=").append(this.bookSet);
        sb.append('}');
        return sb.toString();
    }
}
