package ui;

import java.util.List;

import business.Address;
import business.LibraryMember;
import business.Utilites;
import dataaccess.storge.DataAccessService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewMemberController {
	@FXML
	public Button save_btn;
	@FXML
	public Button back_btn;

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
	public Label error_txt;
	
	@FXML
	public void handleBackButtonAction(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage theStage = (Stage)source.getScene().getWindow();
		
		AdminScreen adminScreen = AdminScreen.INSTANCE;
    	adminScreen.setStage(theStage);
        adminScreen.show(); 
        theStage.hide();
	}
	@FXML
	public void handleSaveButtonAction(ActionEvent event) {
		
		String firstName = first_name.getText().toString();
		String lastName = last_name.getText().toString();
		
		String cityStr = city.getText().toString();
		String stateStr = state.getText().toString();
		String streetStr = street.getText().toString();
		String zipStr = zip.getText().toString();
		String telphoneStr = telphone.getText().toString();
		
		
		
		
		if(!firstName.equals("") && !last_name.equals("")&&  !city.equals("")
				&& !state.equals("")&&  !street.equals("")&& !zip.equals("")&& !telphone.equals("")) {
			List<LibraryMember> mebers = DataAccessService.getMemberLists();
			Address address = new Address(streetStr,cityStr,stateStr,  zipStr );
			LibraryMember member = new LibraryMember("0"+(mebers.size() + 1 ), firstName, lastName ,address, telphoneStr);
			DataAccessService.addNewMenber(member);
			error_txt.setText("");
			//System.out.println("finished handleSaveButtonAction()");
			
			Node source = (Node) event.getSource();
			Stage theStage = (Stage)source.getScene().getWindow();
			
			AdminScreen adminScreen = AdminScreen.INSTANCE;
	    	adminScreen.setStage(theStage);
	        adminScreen.show(); 
	        theStage.hide();
			
		}else {
		
			error_txt.setText("Please Enter all field");
			
		}
		
		
	}
	

	
}