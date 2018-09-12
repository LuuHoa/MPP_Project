package business;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 8309080721495266420L;
	private String ISBN;
	private int checkoutLength;
	private String title;
	private List<Author> authorList;
	private int numTotalCopies;
	private int numRemainCopies;
	private List<BookCopy> itsCopiesList; 
	
	
	public Book(String ISBN, int checkoutLength, String title, List<Author> authorList) {
		this.ISBN = ISBN;
		this.title = title;
		this.authorList = authorList;
		this.numTotalCopies = 1;
		this.numRemainCopies = 1;
	}
	
	public Book(String ISBN, int checkoutLength, String title, List<Author> authorList, int numTotalCopies) {
		this.ISBN = ISBN;
		this.title = title;
		this.authorList = authorList;
		this.numTotalCopies = numTotalCopies;
		this.numRemainCopies = numTotalCopies;
	}

	public int getNumTotalCopies() {
		return numTotalCopies;
	}

	public int getNumRemainCopies() {
		return numRemainCopies;
	}

	public void setNumRemainCopies(int numRemainCopies) {
		this.numRemainCopies = numRemainCopies;
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
		if(authorList == null || authorList.size() == 0)
		    return "";
		else
			return authorList.toString(); 
	}

	public void setNumTotalCopies(int numTotalCopies) {
		this.numTotalCopies = numTotalCopies;
	}


	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", checkoutLength=" + checkoutLength + ", title=" + title + ", authorList="
				+ authorList + ", numTotalCopies=" + numTotalCopies + ", numRemainCopies=" + numRemainCopies
				+ ", itsCopiesList=" + itsCopiesList + "]";
	}
}
