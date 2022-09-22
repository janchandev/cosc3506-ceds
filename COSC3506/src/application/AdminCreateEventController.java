package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminCreateEventController extends AdminNavController implements Initializable{
	// Fields for Create Event page
	// Note for future validation: Currently, textfields and textareas cannot contain single quotes as it can create SQL syntax errors
	@FXML
	private TextField createEventName;
	@FXML
	private ChoiceBox<String> createEventClub;
	@FXML
	private TextField createEventDate;
	@FXML
	private TextField createEventTime;
	@FXML
	private TextArea createEventDescription;
	// Scene switch properties
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String[] clubs = {"Coding Enthusiasts", "Gold Gamers", "Earth Club"};	
	
	public void createEvent(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		// Clicking the "Create Event" button sends the inputs to the database
		
		// The following two lines are for creating a connection between the database and the controller
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String clubString = createEventClub.getValue();
		
		String sqlQuery = "INSERT INTO manageevent (EventName, ClubName, Description, DateTime, NoAttendees) VALUES ('" + createEventName.getText() +
				"', '" + clubString + "', '" + createEventDescription.getText() + "', '" + createEventDate.getText() + " " + createEventTime.getText() +
				"', 0)";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		// Redirect to the Manage Events page
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageEvents.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createEventClub.getItems().addAll(clubs);
		
	}


}


