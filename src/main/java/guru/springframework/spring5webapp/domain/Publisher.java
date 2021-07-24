package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Publisher {

    @Id
    @GeneratedValue()
    private Long Id;

    private String name;

    private String addressLine1;

    private String city;

    private String state;

    private String zipCode;

    public Publisher() {
    }

    public Publisher(String name, String addressLine1, String city, String state, String zipCode) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
