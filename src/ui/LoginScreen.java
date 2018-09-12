package ui;


import dataaccess.storge.DataAccessService;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginScreen extends Application {
	
	

    public static void main(String[] args) {
    	DataAccessService.simulateData();
        Application.launch(LoginScreen.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/login.fxml"));
        
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
 

}
