package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewMemberScreen  extends Stage {	
	
	public static final AddNewMemberScreen INSTANCE = new AddNewMemberScreen();
	Stage primaryStage;
	

	
	public void  setStage(Stage ps) {

		primaryStage = ps;

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/ui/add_member.fxml"));
			setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Welcome to our Library");
	
		//show();
	}

}
