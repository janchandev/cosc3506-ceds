package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Application;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//Added in part 2
public class UserEventsViewController extends UserNavController implements Initializable{
	// Fields for the Manage Events table
	@FXML
	private TableView<UserEvents> userEventsTable;
	@FXML
	private TableColumn<UserEvents, String> userEventName;
	@FXML
	private TableColumn<UserEvents, String> userEventClub;
	@FXML
	private TableColumn<UserEvents, String> userEventDescription;
	@FXML
	private TableColumn<UserEvents, String> userEventDate;
	@FXML
	private TableColumn<UserEvents, Integer> userEventId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Methods for loading data from MySQL database into the events table
	
	public ObservableList<UserEvents> getUserEventsList() throws ClassNotFoundException, SQLException {
		ObservableList<UserEvents> userEventsList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT ManageEventsID, EventName, ClubName, Description, DateTime FROM manageevent\r\n"
				+ "WHERE ClubName = 'Coding Enthusiasts' AND ManageEventsID = 19";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		UserEvents userEvents;
		
		while(results.next()) {
			userEvents = new UserEvents(results.getString("EventName"), results.getString("ClubName"), results.getString("Description"),
					results.getString("DateTime"), results.getInt("ManageEventsID"));
			userEventsList.add(userEvents);
		}
		
		return userEventsList;
		
	}
	
	public void displayUserEvents() throws ClassNotFoundException, SQLException {
		ObservableList<UserEvents> list = getUserEventsList();
		userEventName.setCellValueFactory(new PropertyValueFactory<UserEvents, String>("eventName"));
		userEventClub.setCellValueFactory(new PropertyValueFactory<UserEvents, String>("clubName"));
		userEventDescription.setCellValueFactory(new PropertyValueFactory<UserEvents, String>("description"));
		userEventDate.setCellValueFactory(new PropertyValueFactory<UserEvents, String>("dateTime"));
		userEventId.setCellValueFactory(new PropertyValueFactory<UserEvents, Integer>("eventId"));
		
		userEventsTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayUserEvents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void leaveEvent(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM manageevent WHERE ManageEventsID = 19";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		Parent root = FXMLLoader.load(getClass().getResource("UserEventsView.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	

}
	
