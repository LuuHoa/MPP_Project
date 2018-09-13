package business;

import javafx.beans.property.SimpleStringProperty;

public class MemberList {
	private  SimpleStringProperty  id;
	private  final SimpleStringProperty name;
	private  SimpleStringProperty lastName;
	private  SimpleStringProperty phoneNumber;
	private  SimpleStringProperty street;
	private  SimpleStringProperty city;
	private  SimpleStringProperty state;
	private  SimpleStringProperty zip;
	
	
	public MemberList (String id, String name, String lastName, String phoneNumber, 
			String street, String city, String state, String zip) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		
		this.street = new SimpleStringProperty(street);
		this.city = new SimpleStringProperty(city);
		this.state = new SimpleStringProperty(state);
		this.zip = new SimpleStringProperty(zip);
		
	}
	
	public MemberList(String name) {
		this.name = new SimpleStringProperty(name);
	}
	
	
	public String getId() {
		return id.get();
	}
	
	public String getName() {
		return name.get()  + "  " +lastName.get() + " " + phoneNumber.get()+"  "+ street.get() + 
				 " " +  city.get() + " " + state.get() + " " +  zip.get()	;
	}
	public void setName(String n) {
		name.set(n);
	}
	

	
	public SimpleStringProperty getFullName() {
		return new SimpleStringProperty(name.get()+ " " + lastName.get());
	}
	
	public SimpleStringProperty getPhoneNumber() {
		return phoneNumber;
	}
	

	public String getStreet() {
		return street.get();
	}
	
	public String getCity() {
		return city.get();
	}

	public SimpleStringProperty getAddress() {
		return new SimpleStringProperty(street.get() + " " + city.get());
	}
	public SimpleStringProperty getState() {
		return state;
	}
	public SimpleStringProperty getZip() {
		return zip;
	}
	
	
	
	public void setId(String n) {
		id.set(n);
	}
	
	
	public void setLastName(String n) {
		lastName.set(n);
	}
	
	public void setPhoneNumber(String n) {
		phoneNumber.set(n);
	}
	
	public void setStreet(String n) {
		street.set(n);
	}
	
	public void setCity(String n) {
		city.set(n);
	}
	
	
	public void setState(String n) {
		state.set(n);
	}
	
	public void setZip(String n) {
		zip.set(n);
	}


	public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		MemberList c = (MemberList)ob;
		return name.equals(c.name);
	}
	
}
