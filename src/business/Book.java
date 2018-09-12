package business;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 8309080721495266420L;
	private String ISBN;
	private String title;
	private List<Athours> authorList ;
	private int numTotalCopies;
	private int numRemainCopies;
	
	
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

	public String getTitle() {
		return title;
	}

	public List<Athours> getAuthorList() {
		return authorList;
	}

	public void setNumTotalCopies(int numTotalCopies) {
		this.numTotalCopies = numTotalCopies;
	}


	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", authorList=" + authorList + ", numTotalCopies="
				+ numTotalCopies + ", numRemainCopies=" + numRemainCopies + "]";
	}

}
