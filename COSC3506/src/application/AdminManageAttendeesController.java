package application;
//Added in part 2
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminManageAttendeesController extends AdminNavController implements Initializable{
	// Fields for the Manage Event Attendees table
	@FXML
	private TableView<Attendees> attendeeTable;
	@FXML
	private TableColumn<Attendees, String> colAttendeeEvent;
	@FXML
	private TableColumn<Attendees, Integer> colAttendeeStudentId;
	@FXML
	private TableColumn<Attendees, String> colAttendeeName;
	@FXML
	private TableColumn<Attendees, String> colAttendeeEmail;
	@FXML
	private TableColumn<Attendees, Integer> colAttendeeId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Methods for loading data from MySQL database into the attendees table
	public ObservableList<Attendees> getAttendeesList() throws ClassNotFoundException, SQLException {
		ObservableList<Attendees> attendeesList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT * FROM manageeventattendees";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		Attendees attendees;
		
		while(results.next()) {
			attendees = new Attendees(results.getString("EventName"), results.getInt("StudentID"), results.getString("MemberName"),
					results.getString("ContactEmail"), results.getInt("ManageEventAttendeesID"));
			attendeesList.add(attendees);
		}
		
		return attendeesList;
		
	}
	
	public void displayAttendees() throws ClassNotFoundException, SQLException {
		ObservableList<Attendees> list = getAttendeesList();
		colAttendeeEvent.setCellValueFactory(new PropertyValueFactory<Attendees, String>("eventName"));
		colAttendeeStudentId.setCellValueFactory(new PropertyValueFactory<Attendees, Integer>("studentId"));
		colAttendeeName.setCellValueFactory(new PropertyValueFactory<Attendees, String>("memberName"));
		colAttendeeEmail.setCellValueFactory(new PropertyValueFactory<Attendees, String>("contactEmail"));
		colAttendeeId.setCellValueFactory(new PropertyValueFactory<Attendees, Integer>("attendeeId"));
		
		attendeeTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayAttendees();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public void deleteAttendee(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM manageeventattendees WHERE ManageEventAttendeesID = 5";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		String sqlQuery2 = "UPDATE manageevent SET NoAttendees = 1 WHERE ManageEventsID = 15";
		Statement statement2 = connection.createStatement();
		statement2.executeUpdate(sqlQuery2);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageAttendees.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
