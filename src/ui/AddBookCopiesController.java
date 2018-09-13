package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.Book;
import dataaccess.storge.DataAccessService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AddBookCopiesController implements Initializable {

	@FXML
	TextField search;

	@FXML
	Text result;

	@FXML
	TextField input;

	@FXML
	Button submit;
	@FXML
	public Button back_btn;
	
	Book choseBook;

	@FXML
	public void handleBackButtonAction(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage theStage = (Stage)source.getScene().getWindow();
		
		BookCollectionScreen addCollection = BookCollectionScreen.INSTANCE;
		addCollection.setStage(theStage);
		addCollection.show(); 
        theStage.hide();
	}
	
	
	public void onClick(ActionEvent event) {

		String num = input.getText();
		
		
		try {
			if (num == null) return;
			choseBook.addBookCopies(Integer.parseInt(input.getText()));
			DataAccessService.saveAllBooks();
			DataAccessService.ReadBookFromFile();
			
			result.setText("Title: " + choseBook.getTitle() + " now  has " + choseBook.getNumTotalCopies() + " copies");
			
			
			Node source = (Node) event.getSource();
			Stage theStage = (Stage)source.getScene().getWindow();
			
			BookCollectionScreen addCollection = BookCollectionScreen.INSTANCE;
			addCollection.setStage(theStage);
//			adminScreen.setData(Utilites.getTableList());
			addCollection.show(); 
	        theStage.hide();
			
		} catch(Exception ex) {
			result.setText("Incorrect input"+ ex.getMessage());

		}
		

	}

	public void onSearch(ActionEvent event) {

		DataAccessService.loadAllBooks();
		choseBook = DataAccessService.getBook(search.getText());
		result.setTextAlignment(TextAlignment.CENTER);
		if (choseBook == null)
			result.setText("Wrong Book ISBN");
		else {
			result.setText("Title: " + choseBook.getTitle() + " has " + choseBook.getNumTotalCopies() + " copies");
			input.setDisable(false);
			submit.setDisable(false);
		}

	}
	
	
	public void onExit(ActionEvent event) {

		System.out.println("Exit");

	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		result.setText("");
		input.setDisable(true);
		submit.setDisable(true);

	}

}
