package guru.springframework.spring5webapp.domain;

public class Address {

	private long zipCode;
	private String state;
	private String city;
	private String addressLine1;
	
	public Address() { }
	
	
	
	public Address(long zipCode, String state, String city, String addressLine1) 
	{
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.addressLine1 = addressLine1;
	}



	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
}
