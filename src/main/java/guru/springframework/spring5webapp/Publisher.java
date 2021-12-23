package guru.springframework.spring5webapp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    private String name;
    private String city;
    private String state;
    private String adress;
    private Long zip;

    @OneToMany()
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Publisher() {
    }

    public Publisher(String name, String city, String state, String adress, Long zip) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.adress = adress;
        this.zip = zip;
    }

    public Publisher(String name, String city, String state, String adress, Long zip, Set<Book> books) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.adress = adress;
        this.zip = zip;
        this.books = books;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
