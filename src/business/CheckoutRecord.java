package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord  implements Serializable {
	
	private LibraryMember member;
	private List<CheckOutEntry> checkOutEntries;
	
	public CheckoutRecord(LibraryMember member) {
		this.member = member;
		this.checkOutEntries = new ArrayList<CheckOutEntry>();
	}

	public LibraryMember getMember() {
		return member;
	}
	
	public List<CheckOutEntry> getCheckOutEntries() {
		return checkOutEntries;
	}

	public void addEntry(CheckOutEntry e) {
		
	}
}
