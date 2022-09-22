package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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

public class AdminEditEventController extends AdminNavController implements Initializable {
	// Fields for Edit Event page
	@FXML
	private TextField editEventName;
	@FXML
	private ChoiceBox<String> editEventClub;
	@FXML
	private TextField editEventDate;
	@FXML
	private TextField editEventTime;
	@FXML
	private TextArea editEventDescription;
	private String[] clubs = {"Coding Enthusiasts", "Gold Gamers", "Earth Club"};
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void editEvent(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String clubString = editEventClub.getValue();
		
		String sqlQuery = "UPDATE manageevent SET EventName = '" + editEventName.getText() +
				"', ClubName = '" + clubString + "', Description = '" + editEventDescription.getText() +
				"', DateTime = '" + editEventDate.getText() + " " + editEventTime.getText() +
				"' WHERE ManageEventsID = 13";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageEvents.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		editEventClub.getItems().addAll(clubs);
		
	}
}
