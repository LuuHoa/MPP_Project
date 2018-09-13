package business;

import java.io.Serializable;

public class Author implements Serializable{
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	private String bio;
	
	public Author(String firstName, String lastName, Address address,  String phoneNumber, String bio) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bio = bio;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getBio() {
		return bio;
	}
	
	
}
