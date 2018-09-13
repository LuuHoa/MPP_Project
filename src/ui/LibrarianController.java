package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LibrarianController implements Initializable {

    @FXML private Button sceneButton1;
    @FXML private Button sceneButton2;
    @FXML private Button sceneButton3;
    
    
    @FXML
    public void handleMenuButtonAction (ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == sceneButton1){
        
        	Node source = (Node) event.getSource();
    		Stage theStage = (Stage)source.getScene().getWindow();
    		
    		CheckoutScreen cs = CheckoutScreen.INSTANCE;
    		cs.setStage(theStage);
    		cs.show();
    		
        } else if (event.getSource() == sceneButton2){
        	
        	Node source = (Node) event.getSource();
    		Stage theStage = (Stage)source.getScene().getWindow();
    		
    		CheckoutListScreen cs = CheckoutListScreen.INSTANCE;
    		cs.setStage(theStage);
    		cs.show();
    		
        } else if (event.getSource() == sceneButton3) {
        	
        	Node source = (Node) event.getSource();
    		Stage theStage = (Stage)source.getScene().getWindow();
    		
    		overDueDateScreen cs = overDueDateScreen.INSTANCE;
    		cs.setStage(theStage);
    		cs.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
    

}
