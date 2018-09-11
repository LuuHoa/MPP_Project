package business;

import java.io.Serializable;
import java.util.List;

public class LibraryStaff implements Serializable {

	private String id;
	private String password;
	private List<MemberRole> roleList;
}
