package ui;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookCollectionController implements Initializable {

	@FXML
	Text title;


	@FXML
	TableView<Book> bookTbl;
	@FXML
	TableColumn<Book, String> bookTitleCol;
	@FXML
	TableColumn<Book, String> bookISBNCol;
	@FXML
	TableColumn<Book, String> bookAuthorsCol;
	@FXML
	TableColumn<Book, String> bookLengthCol;
	@FXML
	TableColumn<Book, String> bookCopiesCol;
	
	
	@FXML
	Button addCopiesBtn;
	
	@FXML
	Button addBookBtn;

	private final ObservableList<Book> data = FXCollections.observableArrayList(new Book("Jacob", 7, "Smith", null),
			new Book("Isabella", 7, "Johnson", null), new Book("Ethan", 7, "Williams", null),
			new Book("Emma", 7, "Jones", null), new Book("Michael", 7, "Brown", null));

	private ObservableList<Book> booksData;

	public void onClick(ActionEvent event) {


		Node source = (Node) event.getSource();
		Stage theStage = (Stage)source.getScene().getWindow();
		
		AddNewBookScreen addNewBook = AddNewBookScreen.INSTANCE;
		addNewBook.setStage(theStage);
		addNewBook.show();  
	
	}

	public void onEdit(ActionEvent event) {
		// Parent root;
		 

			Node source = (Node) event.getSource();
			Stage theStage = (Stage)source.getScene().getWindow();
			
			AddBookCopiesScreen addNewBookCopy = AddBookCopiesScreen.INSTANCE;
			addNewBookCopy.setStage(theStage);
			addNewBookCopy.show();  
		
//	        try {
//	            root = FXMLLoader.load(getClass().getClassLoader().getResource("/ui/AddBookCopies.fxml"));
//	            Stage stage = new Stage();
//	            stage.setTitle("Add new Book Copies");
//	            stage.setScene(new Scene(root, 450, 450));
//	            stage.show();
//	            // Hide this current window (if this is what you want)
//	           // ((Node)(event.getSource())).getScene().getWindow().hide();
//	        }
//	        catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DataAccessService.loadAllBooks();
		
		booksData = FXCollections.observableArrayList(DataAccessService.allBooks);
		bookTbl.getItems().addAll(booksData);
		bookTbl.setEditable(true);

		bookTitleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
		bookISBNCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getISBN()));
		bookAuthorsCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAuthorListString()));
		bookLengthCol
				.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getCheckoutLength())));
		bookCopiesCol
				.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumTotalCopies())));

	//	addCopiesCol.setCellFactory(c -> new SimpleStringProperty());
	//	addCopiesCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}

}
