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

public class UserNavController {
	// Scene switch properties
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private VBox vboxNav;
	
	
	// Scene switch methods
	public void switchToMyClubs(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserClubsView.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToJoinClubs(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserJoinClubs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToMyEvents(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserEventsView.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToJoinEvents(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserJoinEvents.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void switchToAccountSettings(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserAccountSettings.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void switchToManageNotifications(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserManageNotifications.fxml"));
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
	
	public void showVbox(ActionEvent e) {
		vboxNav.setVisible(true);
	}
	
	public void switchToPayment(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserPayment.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	

}