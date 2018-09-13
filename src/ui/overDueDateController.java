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

public class overDueDateController {
	@FXML
	public TextField tID;
	@FXML
	public Label lbError;
	@FXML
	public Button btnSearch;

	@FXML
	public TableView<OverDue> tvOverDue;
	@FXML
	public TableColumn<OverDue, String> tcISBN;
	@FXML
	public TableColumn<OverDue, String> tcTitle;
	@FXML
	public TableColumn<OverDue, String> tcCopyNoID;
	@FXML
	public TableColumn<OverDue, String> tcMember;

	@FXML
	public TableColumn<OverDue, String> tcDueBack;

	public void onClickBtnSearch(ActionEvent event) {
		this.tvOverDue.getItems().clear();
		lbError.setText("");
		DataAccessService.loadAllRecords();
		DataAccessService.loadAllBooks();
		DataAccessService.loadAllMembers();

		try {

			Book searchBook = DataAccessService.getBook(tID.getText());
			
			List<OverDue> ov = new ArrayList<OverDue>();
			for (CheckoutRecord rec : DataAccessService.allRecords) {
				String member = rec.getMember().getId() +" "+ rec.getMember().getFirstName() + " "
						+ rec.getMember().getLastName();
				for (CheckOutEntry e : rec.getCheckOutEntries()) {
					if (e.getBookCopy().getOrgBook().equals(searchBook) && e.getDueDate().isBefore(LocalDate.now())) {
					    System.out.println(e);
						Book org = e.getBookCopy().getOrgBook();
						System.out.println(org.toString());
						ov.add(new OverDue(org.getISBN(), org.getTitle(), e.getBookCopy().getCopyNum(), member,
								e.getDueDate().toString()));
					}
				}
			}
			System.out.println(ov.size());
			ObservableList<OverDue> data = FXCollections.observableArrayList(ov);
			this.tvOverDue.getItems().addAll(data);
			 
			
			tcISBN.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getISBN()));
			tcTitle.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
			tcMember.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMember()));
			tcCopyNoID.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCopyNoId()));
			tcDueBack.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getDueBackDate().toString())));
			
			
		} catch (Exception ex) {
			//ex.printStackTrace();
			lbError.setText("Wrong input ISBN");
		}

	}

	class OverDue {
		private String ISBN;
		private String Title;
		private String CopyNoId;
		private String Member;
		private String DueBackDate;

		OverDue(String ISBN, String Title, String CopyNoId, String Member, String DueBackDate) {
			this.ISBN = ISBN;
			this.Title = Title;
			this.CopyNoId = CopyNoId;
			this.Member = Member;
			this.DueBackDate = DueBackDate;
		}

		public String getISBN() {
			return ISBN;
		}

		public String getTitle() {
			return Title;
		}

		public String getCopyNoId() {
			return CopyNoId;
		}

		public String getMember() {
			return Member;
		}

		public String getDueBackDate() {
			return DueBackDate;
		}

	}

	/*
	 * @FXML void onClickBtnSearch(ActionEvent event) { String id = tID.getText();
	 * lbError.setText("");
	 * 
	 * LibraryMember mem = new LibraryMember();
	 * 
	 * // Validate input data if(id.equals("")) {
	 * lbError.setText("Please enter Member ID"); } else { mem =
	 * DataAccessService.getMember(id); if (mem == null) {
	 * lbError.setText("Member ID is not available"); } else {
	 * 
	 * ObservableList<CheckOutEntry> data = FXCollections.observableArrayList();
	 * 
	 * for(CheckoutRecord c : DataAccessService.allRecords) { if
	 * (c.getMember().getId().equals(id)) { data.addAll(c.getCheckOutEntries()); } }
	 * 
	 * tcBookTitle.setCellValueFactory(c-> new
	 * SimpleStringProperty(c.getValue().getBookCopy().getOrgBook().getTitle()));
	 * tcCheckoutDate.setCellValueFactory(c-> new
	 * SimpleStringProperty(c.getValue().getCheckoutDate().toString()));
	 * tcDueDate.setCellValueFactory(c-> new
	 * SimpleStringProperty(c.getValue().getDueDate().toString()));
	 * 
	 * tvCheckoutRecord.setItems(data); } } }
	 */

}
