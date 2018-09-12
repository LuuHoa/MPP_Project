package business;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 8309080721495266420L;
	private String street;
	private String city;
	private String stae;
	private String zip;
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getStae() {
		return stae;
	}
	public String getZip() {
		return zip;
	}

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.stae = state;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", stae=" + stae + ", zip=" + zip + "]";
	}
}
