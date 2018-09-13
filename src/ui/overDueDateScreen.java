package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class overDueDateScreen extends Stage {	
	
	public static final overDueDateScreen INSTANCE = new overDueDateScreen();
	Stage primaryStage;

	
	public void  setStage(Stage ps) {

		primaryStage = ps;

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/ui/overDueDate.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Check over due date rental Book");
	
		//show();
	}

}
