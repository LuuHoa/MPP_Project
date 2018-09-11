package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MemberInfoController {
	@FXML private TextField tMemberID;
	@FXML private TextField tFirstName;
	@FXML private TextField tLastName;
	@FXML private TextField tStreet;
	@FXML private TextField tCity;
	@FXML private TextField tState;
	@FXML private TextField tZipcode;
	@FXML private TextField tPhone;
	
	@FXML private Button btnAdd;
	
    @FXML void onClickBtnAdd(ActionEvent event) {
    	System.out.println(tMemberID.getText());
    }
}
