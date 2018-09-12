package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry  implements Serializable {

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;

}
