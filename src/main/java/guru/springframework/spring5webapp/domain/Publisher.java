package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String publisherName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book>books = new HashSet<>();
	
	
	
	
	public Publisher() {
		super();
	}
	
	public Publisher(String publisherName, String streetAddress, String city, String state, String zipCode) {
		super();
		this.publisherName = publisherName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		Publisher pub = (Publisher)obj;
		return id != null ? id == pub.getId() : pub.id == null;
		
		
		
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
	
	
	

}
