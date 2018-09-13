package ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AddBookCopiesScreen extends Stage {	
	
	public static final AddBookCopiesScreen INSTANCE = new AddBookCopiesScreen();
	Stage primaryStage;
	
	public void  setStage(Stage ps) {

		primaryStage = ps;

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/ui/AddBookCopies.fxml"));
		
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setScene(scene);
			
			ps.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    public void handle(WindowEvent we) {
			      System.out.println("Stage is closing");
			    }
			  });
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Add Book Copies");
	
		//show();
	}
	


}
