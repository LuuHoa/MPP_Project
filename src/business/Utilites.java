package business;

import java.util.ArrayList;
import java.util.List;

import dataaccess.storge.DataAccessService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Utilites {
	public static ObservableList<MemberList>  getTableList(){
		

		 List<LibraryMember> list = DataAccessService.getMemberLists();
		 
		 List<MemberList> tableList = new ArrayList<>();
		 
		 for(LibraryMember member :list) {
			 MemberList m = new MemberList (member.getId() + "" , member.getFirstName(), member.getLastName(),
					 member.getPhoneNumber(), member.getAddress().getStreet(), member.getAddress().getCity(),
					 member.getAddress().getState(), member.getAddress().getZip()); 
			 tableList.add(m);
		 }
		 ObservableList<MemberList> USER_LIST_DATA = FXCollections.observableArrayList(tableList);
		 return USER_LIST_DATA;
		
	}
}
