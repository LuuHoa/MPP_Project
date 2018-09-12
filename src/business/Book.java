package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dataaccess.storge.DataAccessService;

public class Book implements Serializable {

	private static AtomicInteger count = new AtomicInteger(0);
	private static final long serialVersionUID = 8309080721495266420L;
	private String ISBN;
	private int checkoutLength;
	private String title;
	private List<Author> authorList;
	private int numTotalCopies;
	private List<BookCopy> itsCopiesList;

	public Book(String ISBN, int checkoutLength, String title, List<Author> authorList) {
		this.ISBN = ISBN;
		this.checkoutLength = checkoutLength;
		this.title = title;
		this.authorList = authorList;
		this.numTotalCopies = 1;
		this.itsCopiesList = new ArrayList<BookCopy>();
		BookCopy bc = new BookCopy(this, String.valueOf(count.incrementAndGet()));
		this.itsCopiesList.add(bc);

	}

	public Book(String ISBN, int checkoutLength, String title, List<Author> authorList, int numTotalCopies) {
		this.ISBN = ISBN;
		this.checkoutLength = checkoutLength;
		this.title = title;
		this.authorList = authorList;
		this.numTotalCopies = numTotalCopies;
		this.itsCopiesList = new ArrayList<BookCopy>();
		for (int i = 0; i < numTotalCopies; i++) {
			BookCopy bc = new BookCopy(this, String.valueOf(count.incrementAndGet()));
			this.itsCopiesList.add(bc);
		}

	}

	public List<BookCopy> getItsCopiesList() {
		return itsCopiesList;
	}

	public int getNumTotalCopies() {
		return numTotalCopies;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getCheckoutLength() {
		return checkoutLength;
	}

	public String getTitle() {
		return title;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public String getAuthorListString() {
		if (authorList == null || authorList.size() == 0)
			return "";
		else
			return authorList.toString();
	}

	public void setNumTotalCopies(int numTotalCopies) {
		this.numTotalCopies = numTotalCopies;
		}

	public void addBookCopies(int increaseNum) {

		for (int i = 0; i < increaseNum; i++) {
			BookCopy bc = new BookCopy(this, String.valueOf(count.incrementAndGet()));
			this.itsCopiesList.add(bc);
		}
		this.numTotalCopies = this.numTotalCopies + increaseNum;

	}

	
	
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", checkoutLength=" + checkoutLength + ", title=" + title + ", authorList="
				+ authorList + ", numTotalCopies=" + numTotalCopies 
				+ ", itsCopiesList=" + itsCopiesList + "]";
	}
	
	public BookCopy getNextCopy() {
		for (BookCopy c : this.getItsCopiesList()) {
			if (c.isAvailable()) return c;
		}
		return null;
	}
}
