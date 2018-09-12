package business;

import java.io.Serializable;
import java.util.List;

public class LibraryStaff implements Serializable {

	private String id;
	private String password;
	private String memberRole;
	List<MemberRole> roleList;
	
	public LibraryStaff(String id, String password, String memberRole) {
		this.id = id;
		this.password = password;
		this.memberRole = memberRole;
		
		
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getMemberRole() {
		return memberRole;
	}

	

	

    @Override
    public String toString() {
         return new StringBuffer(" id : ").append(this.id)
        		 .append(", password : ").append(this.password)
        		 .append(", memberRole : ").append(this.memberRole)
        		 .toString();
         }
	
	
	
}
