package ui;

import java.time.LocalDate;
import java.util.List;

import business.CheckOutEntry;
import business.LibraryMember;
import dataaccess.storge.DataAccessService;
import business.Book;
import business.BookCopy;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class CheckoutController {
	
	@FXML public TextField tID;
	@FXML public TextField tISBN;
	@FXML public Label lbError;
	@FXML public Button btnCheckout;
	@FXML public Button btnAdd;
	
	@FXML public TableView<CheckOutEntry> tvCheckoutRecord;
	@FXML public TableColumn<CheckOutEntry, String> tcBookTitle;
	@FXML public TableColumn<CheckOutEntry, String> tcCheckoutDate;
	@FXML public TableColumn<CheckOutEntry, String> tcDueDate;
	
	@FXML void onClickBtnAdd(ActionEvent event) {

	}
	
    @FXML void onClickBtnCheckout(ActionEvent event) {
    	
    	// To be removed: mimic load data
    	ObservableList<CheckOutEntry> data =
                FXCollections.observableArrayList(
//                		new CheckOutEntry(LocalDate.now(), new BookCopy("123")),
//                		new CheckOutEntry(LocalDate.now(), new BookCopy("456")),
//                		new CheckOutEntry(LocalDate.now(), new BookCopy("789"))
                		);  	
    	// End of removed

    	tcBookTitle.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBookCopy().getOrgBook().getTitle()));
    	tcCheckoutDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCheckoutDate().toString()));
    	tcDueDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDueDate().toString()));
    }
	
	
}
