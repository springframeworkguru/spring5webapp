package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Aezzat
 */
@Entity
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String address;

	public Publisher()
	{
	}

	public Publisher(String name, String address)
	{
		this.name = name;
		this.address = address;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Publisher))
			return false;
		Publisher publisher = (Publisher) o;
		return Objects.equals(id, publisher.id);
	}

	@Override public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override public String toString()
	{
		return "Publisher{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\''
				+ '}';
	}
}
