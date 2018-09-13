package ui;

import business.MemberList;
import business.Utilites;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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
	private TableView<MemberList> table = new TableView<MemberList>();

	Text pleaseSelect = new Text();
	
	public void setData(ObservableList<MemberList> members) {
//		table.refresh();	
//		table.getColumns().get(0).setVisible(false);
//		table.getColumns().get(0).setVisible(true);
//	
//		table.setItems(members);
		table.getItems().clear();
		table.getItems().addAll(Utilites.getTableList_());
	
	}
	
   public AdminScreen() {}
	public void setStage(Stage stage) {
	
		pleaseSelect.setFill(Color.FIREBRICK);
		
		setTitle("Member List");
		
		final Label label = new Label("Member");
        label.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(label);
		
		TableColumn<MemberList, String> catalogNameCol = new TableColumn<>("MemberList");
		catalogNameCol.setMinWidth(500);
		catalogNameCol.setCellValueFactory(
            new PropertyValueFactory<MemberList, String>("name"));
		catalogNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(catalogNameCol);
		
		Button addButton = new Button("Add user");
		Button viewButton = new Button("View Books");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(table, 0, 1);
		grid.add(pleaseSelect, 0, 2);
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(viewButton);
		btnBox.getChildren().add(addButton);
		grid.add(btnBox,0,4);
		grid.add(new HBox(10), 0, 5);
		
       
		 
		addButton.setOnAction(evt -> {
			AddNewMemberScreen newMemberScreen = AddNewMemberScreen.INSTANCE;
			newMemberScreen.setStage(stage);
			newMemberScreen.show();  
			close();
			
		});
	       
	       
		viewButton.setOnAction(evt -> {
			//todo link to kim code
			
			AddNewBookScreen newBookScreen = AddNewBookScreen.INSTANCE;
			newBookScreen.setStage(stage);
			newBookScreen.show();  
			close();
		
		});
        Scene scene = new Scene(grid, 600, 400);  
        setScene(scene);
	}

}
