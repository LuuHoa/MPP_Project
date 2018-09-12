package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	
	private String copyNum;
	private boolean isAvailable;
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
	}

	public String getCopyNum() {
		return copyNum;
	}

	public Book getOrgBook() {
		return orgBook;
	}
	

}
