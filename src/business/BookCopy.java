package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String copyNum;
	private boolean isAvailable;
<<<<<<< HEAD
	private Book orgBook;

	public BookCopy(Book orgBook, String copyNum) {
		this.orgBook = orgBook;
		this.copyNum = copyNum;
		this.isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
=======
	Book book;

	public BookCopy(String copyNum) {
		this.copyNum = copyNum;
>>>>>>> cf3190d02321355def86e5521fb0aafb33e142a2
	}

	public String getCopyNum() {
		return copyNum;
	}
<<<<<<< HEAD

	public Book getOrgBook() {
		return orgBook;
	}
	
=======
>>>>>>> cf3190d02321355def86e5521fb0aafb33e142a2

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public BookCopy(String copyNum, Book book) {
		this.copyNum = copyNum;
		this.isAvailable = true;
		this.book = book;
	}
	
	
}
