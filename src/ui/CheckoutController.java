package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.CheckOutEntry;
import business.CheckoutRecord;
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
import javafx.scene.paint.Color;


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
		String id = tID.getText();
		String isbn = tISBN.getText();
		lbError.setText("");
		
		LibraryMember mem = new LibraryMember();
		Book b = new Book();
		BookCopy cp = new BookCopy();
		
		// Validate input data
		if(id.equals("")) {
			lbError.setText("Please enter Member ID");
		} else {
			mem = DataAccessService.getMember(id);
			if (mem == null) {
				lbError.setText("Member ID is not available");
			} else if (isbn.equals("")) {
				lbError.setText("Please enter ISBN number");
			} else {
				b = DataAccessService.getBook(isbn);
				if (b == null) {
					lbError.setText("Book is not available");
				} else {
					cp = b.getNextCopy();
					if (cp == null) {
						lbError.setText("There is no available copy of this book");
					} else {
						// Create new checkout record
						CheckoutRecord rc = new CheckoutRecord(mem);
						cp.setAvailable(false);
						rc.addEntry(new CheckOutEntry(LocalDate.now(), cp));
						DataAccessService.allRecords.add(rc);
						
				    	ObservableList<CheckOutEntry> data =
				                FXCollections.observableArrayList(rc.getCheckOutEntries());

				    	tcBookTitle.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBookCopy().getOrgBook().getTitle()));
				    	tcCheckoutDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCheckoutDate().toString()));
				    	tcDueDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDueDate().toString()));
				    	
				    	tvCheckoutRecord.getItems().addAll(data);
					}
				}
			}
		}
	}
	
    @FXML void onClickBtnCheckout(ActionEvent event) {
    	tID.clear();
    	tISBN.clear();
    	lbError.setText("");
    	tvCheckoutRecord.getItems().clear();
    	DataAccessService.saveAllBooks();
    	DataAccessService.saveAllRecords();
    }
	
	
}
