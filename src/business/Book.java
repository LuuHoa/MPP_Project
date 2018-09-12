package business;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 8309080721495266420L;
	private String ISBN;
	private String title;
	private  List<Athours> autherList ;
	private boolean  isAvailable;

}
