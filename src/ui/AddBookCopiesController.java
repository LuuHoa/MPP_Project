package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.Book;
import dataaccess.storge.DataAccessService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AddBookCopiesController implements Initializable {

	@FXML
	TextField search;

	@FXML
	Text result;

	@FXML
	TextField input;

	@FXML
	Button submit;

	Book choseBook;

	public void onClick(ActionEvent event) {

		System.out.println("Save");
		String num = input.getText();
		
		
		try {
			if (num == null) return;
			choseBook.addBookCopies(Integer.parseInt(input.getText()));
			DataAccessService.saveAllBooks();
			DataAccessService.ReadBookFromFile();
			
			result.setText("Title: " + choseBook.getTitle() + " now  has " + choseBook.getNumTotalCopies() + " copies");
			
		} catch(Exception ex) {
			result.setText("Incorrect input"+ ex.getMessage());

		}
		

	}

	public void onSearch(ActionEvent event) {

		System.out.println("Search");

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		result.setText("");
		input.setDisable(true);
		submit.setDisable(true);

	}

}
