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
		return "CheckOutEntry [checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", book=" + bookCopy + "]";
	}
}
