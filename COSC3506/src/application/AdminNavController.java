package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminNavController {
	// Scene switch properties
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private VBox navVbox;
	
	
	// Scene switch methods
	public void switchToManageClubs(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageClubs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToCreateClubs(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminCreateClubs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToManageEvents(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageEvents.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToCreateEvents(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminCreateEvent.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void switchToLogin(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void showNavVbox(ActionEvent e) {
		navVbox.setVisible(true);
	}
	
	

}
