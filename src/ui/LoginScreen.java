package ui;


import business.Utilites;
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
	
	Stage primaryStage;
	public void openAdminScreen() {
		
		AdminScreen adminScreen = AdminScreen.INSTANCE;
		adminScreen.setStage(primaryStage);
		adminScreen.setData(Utilites.getTableList());
		adminScreen.show();  
		//primaryStage.hide();
		 
	}
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/login.fxml"));
        
        primaryStage = stage;
        
        stage.setTitle("Welcome to our Library");
        stage.setScene(new Scene(root));
        stage.show();
        
       
    }
    
 

}