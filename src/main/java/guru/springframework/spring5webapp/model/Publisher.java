package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    private String name;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return zip == publisher.zip && Objects.equals(name, publisher.name) && Objects.equals(address, publisher.address) && Objects.equals(city, publisher.city) && Objects.equals(state, publisher.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city, state, zip);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    private String city;
    private String state;
    private int zip;

    public Publisher(){};

    public Publisher(String name, int zip, String city, String address, String state) {
        this.name = name;
        this.zip = zip;
        this.city = city;
        this.address = address;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
