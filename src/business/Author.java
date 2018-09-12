package business;

import java.io.Serializable;

public class Author implements Serializable{
	
	@Override
	public String toString() {
		return "Author [firstNAme=" + firstNAme + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", bio=" + bio + "]";
	}
	private String firstNAme;
	private String lastName;
	private Address address;
	private String phoneNumber;
	private String bio;
	
	
}
