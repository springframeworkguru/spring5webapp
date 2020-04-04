package guru.springframework.spring5webapp.domain;

public class Publisher
{
	String name;

	public Publisher(String name)
	{
		this.name = name;
	}

	public Publisher()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
