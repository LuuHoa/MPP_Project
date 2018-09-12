package ui;

import java.util.ArrayList;
import java.util.List;

import business.LibraryStaff;
import dataaccess.storge.DataAccessService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	public Label error_txt;

	@FXML
	public Button login_btn;

	@FXML
	public TextField member_id;

	@FXML
	public PasswordField password_txt;

	@FXML
	public void handleLoginButtonAction(ActionEvent event) {

		String id = member_id.getText().toString();
		String password = password_txt.getText().toString();
		boolean found = false;
		if (id.equals("")) {
			error_txt.setText("Please Enter valid ID");
		} else if (password.equals("")) {
			error_txt.setText("Please Enter valid Password");
		} else {
			List<LibraryStaff> staffList = DataAccessService.getLibaryMembers();

			for (LibraryStaff staff : staffList) {
				if (staff.getId().equals(id) && staff.getPassword().equals(password)) {
					error_txt.setText("valid id  Password : " + staff.getMemberRole() );
					found = true;
					break;
				}
			}
			if (!found)
				error_txt.setText("invalid Id or Password");

		}

		// display addresses

	}

}
