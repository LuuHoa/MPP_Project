package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.MemberList;
import business.Utilites;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController implements Initializable {
	@FXML
	Text title;

	@FXML
	TableView<MemberList> memenrTbl;
	@FXML
	TableColumn<MemberList, String> name;
	@FXML
	TableColumn<MemberList, String> phone;
	@FXML
	TableColumn<MemberList, String> address;
	@FXML
	TableColumn<MemberList, String> state;
	@FXML
	TableColumn<MemberList, String> zip;

	@FXML
	Button addUserBtn;

	@FXML
	Button viewBook;

	@FXML
	Button checkout;

	@FXML
	public void addUserEvent(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage theStage = (Stage) source.getScene().getWindow();

		AddNewMemberScreen newMemberScreen = AddNewMemberScreen.INSTANCE;
		newMemberScreen.setStage(theStage);
		newMemberScreen.show();
		theStage.hide();
	}

	@FXML
	public void viewBook(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage theStage = (Stage) source.getScene().getWindow();

		BookCollectionScreen bookCollection = BookCollectionScreen.INSTANCE;
		bookCollection.setStage(theStage);
		bookCollection.show();
		theStage.hide();
	}

	@FXML
	public void checkOut(ActionEvent event) {
		Node source2 = (Node) event.getSource();
		Stage theStage = (Stage) source2.getScene().getWindow();

		LibrarianScreen checkout = LibrarianScreen.INSTANCE;
		checkout.setStage(theStage);
		checkout.show();
		theStage.hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		ObservableList<MemberList> memberList = Utilites.getTableList();

		memenrTbl.getItems().addAll(memberList);
		memenrTbl.setEditable(true);

		name.setCellValueFactory(c -> c.getValue().getFullName());
		phone.setCellValueFactory(c -> c.getValue().getPhoneNumber());
		address.setCellValueFactory(c -> c.getValue().getAddress());

		state.setCellValueFactory(c -> c.getValue().getState());
		zip.setCellValueFactory(c -> c.getValue().getZip());

		
		if (Utilites.getUserType().equals("Admin")) {
			checkout.setVisible(false);
		}

	}
}
