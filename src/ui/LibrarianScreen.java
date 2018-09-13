package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibrarianScreen extends Stage {	
	
	public static final LibrarianScreen INSTANCE = new LibrarianScreen();
	Stage primaryStage;

	
	public void  setStage(Stage ps) {

		primaryStage = ps;

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/ui/Librarian.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Librarian screen");
	
		//show();
	}

}

