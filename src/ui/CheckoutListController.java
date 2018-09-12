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

public class CheckoutListController {
	@FXML public TextField tID;
	@FXML public Label lbError;
	@FXML public Button btnSearch;
	@FXML public Button btnPrint;
	
	@FXML public TableView<CheckOutEntry> tvCheckoutRecord;
	@FXML public TableColumn<CheckOutEntry, String> tcBookTitle;
	@FXML public TableColumn<CheckOutEntry, String> tcCheckoutDate;
	@FXML public TableColumn<CheckOutEntry, String> tcDueDate;
	
	@FXML void onClickBtnSearch(ActionEvent event) {
		String id = tID.getText();
		lbError.setText("");
		
		LibraryMember mem = new LibraryMember();

		// Validate input data
		if(id.equals("")) {
			lbError.setText("Please enter Member ID");
		} else {
			mem = DataAccessService.getMember(id);
			if (mem == null) {
				lbError.setText("Member ID is not available");
			} else {

		    	ObservableList<CheckOutEntry> data = FXCollections.observableArrayList();
		    	
		    	for(CheckoutRecord c : DataAccessService.allRecords) {
		    		if (c.getMember().getId().equals(id)) {
		    			data.addAll(c.getCheckOutEntries());
		    		}
		    	}

		    	tcBookTitle.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBookCopy().getOrgBook().getTitle()));
		    	tcCheckoutDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCheckoutDate().toString()));
		    	tcDueDate.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDueDate().toString()));
		    	
		    	tvCheckoutRecord.setItems(data);
			}
		}
	}
	
	@FXML void onClickBtnPrint(ActionEvent event) {
		
	}
}
