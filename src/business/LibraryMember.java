package business;

import java.io.Serializable;

public class LibraryMember implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	
	public String getId() {
		return id;
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
	
	public LibraryMember(String id, String firstName, String lastName, Address address, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "LibraryMember [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + "]";
	}
}
