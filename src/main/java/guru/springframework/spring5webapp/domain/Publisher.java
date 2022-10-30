package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {


            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private  Long id;
            private String name ;
            private String city;
            private String state ;
            private String zip ;
            @OneToMany
            @JoinColumn(name = "publisher_id")
            private Set<Book> books  = new HashSet <> ();


    public Publisher ( ) {

    }

//    public Publisher ( Long id , String name , String city , String state , String zip ) {
//        this.id    = id;
//        this.name  = name;
//        this.city  = city;
//        this.state = state;
//        this.zip   = zip;
//    }

    public Set < Book > getBooks ( ) {
        return books;
    }


    public void setBooks ( Set < Book > books ) {
        this.books = books;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getName ( ) {
        return name;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public String getCity ( ) {
        return city;
    }

    public void setState ( String state ) {
        this.state = state;
    }

    public String getState ( ) {
        return state;
    }

    public void setZip ( String zip ) {
        this.zip = zip;
    }

    public String getZip ( ) {
        return zip;
    }

    @Override
    public String toString ( ) {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }


    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Publisher publisher = ( Publisher ) o;

        return id != null ? id.equals ( publisher.id ) : publisher.id == null;
    }

    @Override
    public int hashCode ( ) {
        return id != null ? id.hashCode () : 0;
    }
}
