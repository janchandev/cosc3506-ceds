package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserPaymentController extends UserNavController {
	@FXML
	private TextField paymentNameCard;
	@FXML
	private TextField paymentCardNumber;
	@FXML
	private TextField paymentCardExpiry;
	@FXML
	private TextField paymentCvv;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void goToConfirmationScreen(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		if (paymentNameCard.getText().isEmpty() || paymentCardNumber.getText().isEmpty() || paymentCardExpiry.getText().isEmpty() || paymentCvv.getText().isEmpty()) {
        Parent root = FXMLLoader.load(getClass().getResource("UserPaymentFail.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
		else {
    	// Lines 39 - 45 added during testing phase
    	DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "INSERT INTO viewclubs (ClubName, ClubDescription, ContactEmail) VALUES ('Coding Enthusiasts', 'A club for all coding enthusiasts from beginner to advanced! Come learn and meet other coding enthusiasts!', 'codingenthusiasts@gmail.com')";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
    	
        Parent root = FXMLLoader.load(getClass().getResource("UserPaymentSuccess.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    	} 
	}
	
	

}
