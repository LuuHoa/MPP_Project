package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry  implements Serializable {

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private Book book;
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public Book getBook() {
		return book;
	}
	
	public CheckOutEntry(LocalDate checkoutDate, Book b) {
		this.checkoutDate = checkoutDate;
		this.dueDate = LocalDate.ofEpochDay(b.getCheckoutLength());
		this.book = b;
	}
}
