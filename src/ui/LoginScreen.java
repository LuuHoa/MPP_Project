package ui;


import business.Utilites;
import dataaccess.storge.DataAccessService;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginScreen extends Application {
	public static final LoginScreen INSTANCE = new LoginScreen();
	
	private static Stage window; 
    public static void main(String[] args) {
    	//DataAccessService.simulateData();
    	DataAccessService.loadAllBooks();
    	DataAccessService.loadAllMembers();
    	DataAccessService.loadAllRecords();

        Application.launch(LoginScreen.class, args);
    }
    public void openAdminScreen() {
    	AdminScreen adminScreen = AdminScreen.INSTANCE;
    	adminScreen.setStage(getPrimaryStage());
        adminScreen.show(); 
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/login.fxml"));
 
        setPrimaryStage(window);
        stage.setTitle("Welcome to our Library");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
      
        stage.show();
       
    }
    
    private void setPrimaryStage(Stage stage) {
    	LoginScreen.window = stage;
    }

    static public Stage getPrimaryStage() {
        return LoginScreen.window;
    }
    
 

}