package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord  implements Serializable {
	
	private static final long serialVersionUID = 5467032815847529663L;
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
		this.checkOutEntries.add(e);
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        int size = checkOutEntries.size();
        for (int i = 0; i < size; i++) {
        	sb.append(checkOutEntries.get(i));
            sb.append(newLine);
            if (i != size - 1) {
	            sb.append("----------------------------------------------------");
	            sb.append(newLine);
            }
        }
        return sb.toString();
    }

}
