package ui;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import business.Book;
import dataaccess.storge.DataAccessService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;

public class BookCollectionController implements Initializable {

	@FXML
	Text title;

	@FXML
	TextField search;

	@FXML
	TableView<Book> bookTbl;
	@FXML
	TableColumn<Book, String> bookTitleCol;
	@FXML
	TableColumn<Book, String> bookISBNCol;
	@FXML
	TableColumn<Book, String> bookAuthorsCol;
	@FXML
	TableColumn<Book, String> bookCopiesCol;
	@FXML
	TableColumn<Book, String> addCopiesCol;
	@FXML
	Button addBookBtn;

	private final ObservableList<Book> data = FXCollections.observableArrayList(new Book("Jacob", 7,"Smith", null),
			new Book("Isabella", 7,"Johnson", null), new Book("Ethan", 7,"Williams", null), new Book("Emma", 7,"Jones", null),
			new Book("Michael", 7, "Brown", null));
	
	
	private ObservableList<Book> booksData;
	
	

	public void onClick(ActionEvent event) {

		System.out.println("Eman");
	}

	public void onEditChange(TableColumn.CellEditEvent<Book, String> addBookNumCopiesEvent) {

		title.setText("Welcome to Uniqlooo");
		Book editBook = bookTbl.getSelectionModel().getSelectedItem();
		int increaseNum = Integer.parseInt(addBookNumCopiesEvent.getNewValue());
		if (1 >= increaseNum)
			editBook.addBookCopies(increaseNum);
		
		else
			return;
		
		bookCopiesCol
		.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumTotalCopies())));
		addCopiesCol.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		booksData = DataAccessService.ReadBookFromFile();
		bookTbl.getItems().addAll(booksData);

		bookTbl.setEditable(true);

		title.setText("Welcome to Uniqlo");
		bookTitleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
		bookISBNCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getISBN()));
		bookAuthorsCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAuthorListString()));
		bookCopiesCol
				.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumTotalCopies())));

		addCopiesCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}

}