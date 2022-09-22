package application;

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

public class AdminManageClubsController extends AdminNavController implements Initializable{
	// Fields for the Manage Events table
	@FXML
	private TableView<Clubs> manageClubsTable;
	@FXML
	private TableColumn<Clubs, String> colClubName;
	@FXML
	private TableColumn<Clubs, String> colClubDescription;
	@FXML
	private TableColumn<Clubs, String> colClubEmail;
	@FXML
	private TableColumn<Clubs, Double> colClubPrice;
	@FXML
	private TableColumn<Clubs, Integer> colNumMembers;
	@FXML
	private TableColumn<Clubs, Double> colClubFunds;
	@FXML
	private TableColumn<Clubs, Integer> colClubId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Methods for loading data from MySQL database into the clubs table
	
	public ObservableList<Clubs> getClubsList() throws ClassNotFoundException, SQLException {
		ObservableList<Clubs> clubsList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT * FROM manageclubs";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		Clubs clubs;
		
		while(results.next()) {
			clubs = new Clubs(results.getString("ClubName"), results.getString("ClubDescription"), results.getString("ContactEmail"),
					results.getDouble("MembershipPrice"), results.getInt("NoMembers"), results.getDouble("TotalFunds"), results.getInt("ManageClubID"));
			clubsList.add(clubs);
		}
		
		return clubsList;
		
	}
	
	public void displayClubs() throws ClassNotFoundException, SQLException {
		ObservableList<Clubs> list = getClubsList();
		colClubName.setCellValueFactory(new PropertyValueFactory<Clubs, String>("clubName"));
		colClubDescription.setCellValueFactory(new PropertyValueFactory<Clubs, String>("clubDescription"));
		colClubEmail.setCellValueFactory(new PropertyValueFactory<Clubs, String>("clubEmail"));
		colClubPrice.setCellValueFactory(new PropertyValueFactory<Clubs, Double>("clubPrice"));
		colNumMembers.setCellValueFactory(new PropertyValueFactory<Clubs, Integer>("numMembers"));
		colClubFunds.setCellValueFactory(new PropertyValueFactory<Clubs, Double>("clubFunds"));
		colClubId.setCellValueFactory(new PropertyValueFactory<Clubs, Integer>("clubId"));
		
		manageClubsTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayClubs();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void switchToManageMembers(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageMembers.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void switchToEditClub(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminEditClub.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void deleteClub(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM manageclubs WHERE ManageClubID = 18";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageClubs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
}
