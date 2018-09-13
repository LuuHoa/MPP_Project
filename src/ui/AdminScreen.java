package ui;

import java.io.IOException;

import business.MemberList;
import business.Utilites;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminScreen extends Stage {
	public static final AdminScreen INSTANCE = new AdminScreen();
//	private TableView<MemberList> table = new TableView<MemberList>();

	public void setData(ObservableList<MemberList> members) {
//		table.refresh();	
//		table.getColumns().get(0).setVisible(false);
//		table.getColumns().get(0).setVisible(true);
//	
//		table.setItems(members);
//		table.getItems().clear();
//		table.getItems().addAll(Utilites.getTableList_());
//	
	}

	Stage primaryStage;

	public AdminScreen() {
	}

	public void setStage(Stage ps) {

		primaryStage = ps;

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/ui/admin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Book Collection");

		// show();
	}


}
