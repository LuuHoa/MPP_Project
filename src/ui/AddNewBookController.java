package ui;

import java.util.ArrayList;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.LibraryMember;
import business.Utilites;
import dataaccess.storge.DataAccessService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewBookController {
	
	@FXML
	public Button save_btn;

	@FXML
	public TextField title;
	@FXML
	public TextField isbn;
	@FXML
	public MenuButton checkout;
	
	@FXML
	public TextField first_name;
	@FXML
	public TextField last_name;
	@FXML
	public TextField city;
	@FXML
	public TextField state;
	
	@FXML
	public TextField street;
	@FXML
	public TextField zip;
	@FXML
	public TextField telphone;
	
	@FXML
	public TextArea bio;
	
	@FXML
	public Label error_txt;
	int duration = 21;
	
	@FXML
	public MenuItem ff;
	@FXML
	public void handleMenuButtonAction(ActionEvent event) {
		String d = ((MenuItem)event.getSource()).getText().toString();
		duration = Integer.parseInt(d);

		System.out.println(d);
	}
	@FXML
	public void handleSaveButtonAction(ActionEvent event) {
		
		String tilelStr = title.getText().toString();
		String isbnStr = isbn.getText().toString();
	
		
		String firstName = first_name.getText().toString();
		String lastName = last_name.getText().toString();
		
		String cityStr = city.getText().toString();
		String stateStr = state.getText().toString();
		String streetStr = street.getText().toString();
		String zipStr = zip.getText().toString();
		String telphoneStr = telphone.getText().toString();
		String bioStr = bio.getText().toString();
		

		
		
		if(!firstName.equals("") && !last_name.equals("")&&  !city.equals("")
				&& !state.equals("")&&  !street.equals("")&& !zip.equals("")&&
				!telphone.equals("")&& !tilelStr.equals("")&&  !isbnStr.equals("")&&!bioStr.equals("")) {
			List<LibraryMember> mebers = DataAccessService.getMemberLists();
			
			Address address = new Address(streetStr,cityStr,stateStr,  zipStr );
			List<Author> authorList = new ArrayList<>();
			authorList.add(new Author(firstName,lastName ,address,telphoneStr, bioStr ));
			Book book = new Book(isbnStr, duration, tilelStr, authorList);
			
			error_txt.setText("");
			DataAccessService.addNewBook(book);
			System.out.println("finished handleSaveButtonAction()");
			
			Node source = (Node) event.getSource();
			Stage theStage = (Stage)source.getScene().getWindow();
			
			AdminScreen adminScreen = AdminScreen.INSTANCE;
	    	adminScreen.setStage(theStage);
			adminScreen.setData(Utilites.getTableList());
	        adminScreen.show(); 
	        theStage.hide();
			
		}else {
		
			error_txt.setText("Please Enter all field");
			
		}
		
		
	}
	

}
