package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	private String name;
	private String address;
	private String city;
	private String state;
	private Long zip;
	
	@OneToMany
	@JoinColumn(name="pubId")
	private Set<Book> books = new HashSet<>(); 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pubId;

	public Publisher() {	
	}
	
	public Publisher(String name, String address, String city, String state, Long zip) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public Long getPubId() {
		return pubId;
	}

	public void setPubId(Long pubId) {
		this.pubId = pubId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pubId);
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
		return Objects.equals(pubId, other.pubId);
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", pubId=" + pubId + "]";
	}
	
	
}
