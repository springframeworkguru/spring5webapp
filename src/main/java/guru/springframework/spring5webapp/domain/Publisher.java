package guru.springframework.spring5webapp.domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String addressLine;
	private String city;
	private String state;
	private String zip;
	
//	(cascade = {CascadeType.ALL})
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {
		
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", addressLine=" + addressLine + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	public Publisher(String name, String addressLine, String city, String state, Integer zip) {
////		super();
//		this.name = name;
//		this.addressLine = addressLine;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
