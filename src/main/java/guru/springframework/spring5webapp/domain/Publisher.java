package guru.springframework.spring5webapp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String state;
    private String zip;
    private String city;

    public Publisher() {
    }

    public  Publisher(String name,String addressLine1,String state,String zip,String city)
    {
        this.name=name;
        this.addressLine1=addressLine1;
        this.zip=zip;
        this.city=city;
        this.state=state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (id != null ? !id.equals(publisher.id) : publisher.id != null) return false;
        if (addressLine1 != null ? !addressLine1.equals(publisher.addressLine1) : publisher.addressLine1 != null)
            return false;
        if (state != null ? !state.equals(publisher.state) : publisher.state != null) return false;
        if (zip != null ? !zip.equals(publisher.zip) : publisher.zip != null) return false;
        return city != null ? city.equals(publisher.city) : publisher.city == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
