package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry implements Serializable {

	private static final long serialVersionUID = 7508481940058530471L;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	
	public CheckOutEntry(LocalDate checkoutDate, BookCopy b) {
		this.checkoutDate = checkoutDate;
		this.dueDate = LocalDate.ofEpochDay(b.getOrgBook().getCheckoutLength());
		this.bookCopy = b;
	}
	
    @Override
    public String toString() {
        return "Book copy: " + getBookCopy() + "\nCheckout date: " + getCheckoutDate() + " | Due date: " + getDueDate();
    }
    
    public String printCheckoutEntry(){
    	String separateLine = String.format("%14s| %18s| %18s\n", "", "", "").replace(' ', '-');
		String data = String.format("%14s| %18s| %18s", getBookCopy().getOrgBook().getTitle(), getCheckoutDate(), getDueDate());
		return separateLine + data;
    }
}
