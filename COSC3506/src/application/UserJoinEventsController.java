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
public class UserJoinEventsController extends UserNavController implements Initializable{
	// Fields for the Manage Events table
	@FXML
	private TableView<JoinEvents> joinEventsTable;
	@FXML
	private TableColumn<JoinEvents, String> colJoinEventName;
	@FXML
	private TableColumn<JoinEvents, String> colJoinEventClub;
	@FXML
	private TableColumn<JoinEvents, String> colJoinEventDescription;
	@FXML
	private TableColumn<JoinEvents, String> colJoinEventDate;
	@FXML
	private TableColumn<JoinEvents, Integer> colJoinEventId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Methods for loading data from MySQL database into the events table
	
	public ObservableList<JoinEvents> getJoinEventsList() throws ClassNotFoundException, SQLException {
		ObservableList<JoinEvents> joinEventsList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT ManageEventsID, EventName, ClubName, Description, DateTime FROM manageevent\r\n"
				+ "WHERE ClubName = 'Coding Enthusiasts';";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		JoinEvents joinEvents;
		
		while(results.next()) {
			joinEvents = new JoinEvents(results.getString("EventName"), results.getString("ClubName"), results.getString("Description"),
					results.getString("DateTime"), results.getInt("ManageEventsID"));
			joinEventsList.add(joinEvents);
		}
		
		return joinEventsList;
		
	}
	
	public void displayJoinEvents() throws ClassNotFoundException, SQLException {
		ObservableList<JoinEvents> list = getJoinEventsList();
		colJoinEventName.setCellValueFactory(new PropertyValueFactory<JoinEvents, String>("eventName"));
		colJoinEventClub.setCellValueFactory(new PropertyValueFactory<JoinEvents, String>("clubName"));
		colJoinEventDescription.setCellValueFactory(new PropertyValueFactory<JoinEvents, String>("description"));
		colJoinEventDate.setCellValueFactory(new PropertyValueFactory<JoinEvents, String>("dateTime"));
		colJoinEventId.setCellValueFactory(new PropertyValueFactory<JoinEvents, Integer>("eventId"));
		
		joinEventsTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayJoinEvents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Added during testing phase
	public void joinEvent(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserEventsView.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
		
	}
	
	
	

}
	
