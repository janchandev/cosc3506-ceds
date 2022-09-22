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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminEditClubController extends AdminNavController{
	// Fields for Create Club page
	@FXML
	private TextField editClubName;
	@FXML
	private TextField editClubEmail;
	@FXML
	private TextField editClubPrice;
	@FXML
	private TextArea editClubDescription;
	// Scene switch properties
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void editClub(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		// Clicking the "Create Club" button sends the inputs to the database
		// The following two lines are for creating a connection between the database and the controller
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "UPDATE manageclubs SET ClubName = '" + editClubName.getText() +
				"', ClubDescription = '" + editClubDescription.getText() +
				"', ContactEmail = '" + editClubEmail.getText() + "', MembershipPrice = " + editClubPrice.getText() +
				" WHERE ManageClubID = 10";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		// Redirect to the Manage Clubs page
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageClubs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
