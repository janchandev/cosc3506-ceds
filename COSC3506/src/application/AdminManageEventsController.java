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

public class AdminManageEventsController extends AdminNavController implements Initializable{
	// Fields for the Manage Events table
	@FXML
	private TableView<Events> manageEventsTable;
	@FXML
	private TableColumn<Events, String> colEventName;
	@FXML
	private TableColumn<Events, String> colEventClubName;
	@FXML
	private TableColumn<Events, String> colEventDescription;
	@FXML
	private TableColumn<Events, String> colDateTime;
	@FXML
	private TableColumn<Events, Integer> colNumAttendees;
	@FXML
	private TableColumn<Events, Integer> colEventId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Methods for loading data from MySQL database into the events table
	
	public ObservableList<Events> getEventsList() throws ClassNotFoundException, SQLException {
		ObservableList<Events> eventsList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT * FROM manageevent";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		Events events;
		
		while(results.next()) {
			events = new Events(results.getString("EventName"), results.getString("ClubName"), results.getString("Description"),
					results.getString("DateTime"), results.getInt("NoAttendees"), results.getInt("ManageEventsID"));
			eventsList.add(events);
		}
		
		return eventsList;
		
	}
	
	public void displayEvents() throws ClassNotFoundException, SQLException {
		ObservableList<Events> list = getEventsList();
		colEventName.setCellValueFactory(new PropertyValueFactory<Events, String>("eventName"));
		colEventClubName.setCellValueFactory(new PropertyValueFactory<Events, String>("clubName"));
		colEventDescription.setCellValueFactory(new PropertyValueFactory<Events, String>("description"));
		colDateTime.setCellValueFactory(new PropertyValueFactory<Events, String>("dateTime"));
		colNumAttendees.setCellValueFactory(new PropertyValueFactory<Events, Integer>("numAttendees"));
		colEventId.setCellValueFactory(new PropertyValueFactory<Events, Integer>("eventId"));
		
		manageEventsTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayEvents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void switchToManageAttendees(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageAttendees.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToEditEvent(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminEditEvent.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void deleteEvent(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM manageevent WHERE ManageEventsID = 22";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageEvents.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	

}
	
