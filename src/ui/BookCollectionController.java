package ui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import business.Book;
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
	Button addBookBtn;

	private final ObservableList<Book> data = FXCollections.observableArrayList(new Book("Jacob", "Smith", null),
			new Book("Isabella", "Johnson", null), new Book("Ethan", "Williams", null), new Book("Emma", "Jones", null),
			new Book("Michael", "Brown", null));

	public void onClick(ActionEvent event) {

		System.out.println("Eman");
	}

	public void onEditChange(TableColumn.CellEditEvent<Book, String> editBookNumCopiesEvent) {

		title.setText("Welcome to Uniqlooo");
		Book editBook = bookTbl.getSelectionModel().getSelectedItem();
		if (editBook.getNumTotalCopies() >= Integer.parseInt(editBookNumCopiesEvent.getNewValue()))
			return;
		else
			editBook.setNumTotalCopies(Integer.valueOf(editBookNumCopiesEvent.getNewValue()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		bookTbl.getItems().addAll(data);

		bookTbl.setEditable(true);

		title.setText("Welcome to Uniqlo");
		bookTitleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
		bookISBNCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getISBN()));
		bookAuthorsCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAuthorListString()));
		bookCopiesCol
				.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumTotalCopies())));

		bookCopiesCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}

}
