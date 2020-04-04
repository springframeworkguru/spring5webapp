package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	public Author(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	public Author()
	{
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Author author = (Author) o;
		return Objects.equals(id, author.id);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public String toString()
	{
		return "Author{" +
						"id=" + id +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						", books=" + books +
						'}';
	}
}
