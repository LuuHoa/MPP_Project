package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    	System.out.println("Alo");
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == sceneButton1){
            stage = (Stage) sceneButton1.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/ui/BookCollection.fxml"));
        } else if (event.getSource() == sceneButton2){
            stage = (Stage) sceneButton2.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/ui/AddBookCopies.fxml"));
        } else if (event.getSource() == sceneButton3) {
            stage=(Stage) sceneButton2.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/ui/overDueDate.fxml"));
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
    

}
