package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String copyNum;
	private boolean isAvailable;
	Book book;

	public BookCopy(String copyNum) {
		this.copyNum = copyNum;
	}

	public String getCopyNum() {
		return copyNum;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public BookCopy(String copyNum, Book book) {
		this.copyNum = copyNum;
		this.isAvailable = true;
		this.book = book;
	}
	
	
}
