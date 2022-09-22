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

public class UserClubsViewController extends UserNavController implements Initializable{
	// Fields for the user clubs view table
	@FXML
	private TableView<UserClubs> userClubsTable;
	@FXML
	private TableColumn<UserClubs, String> colUserClub;
	@FXML
	private TableColumn<UserClubs, String> colUserClubDescription;
	@FXML
	private TableColumn<UserClubs, String> colUserClubEmail;
	@FXML
	private TableColumn<UserClubs, Integer> colUserClubId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Methods for loading data from MySQL database into the user clubs view table
	public ObservableList<UserClubs> getUserClubsList() throws ClassNotFoundException, SQLException {
		ObservableList<UserClubs> userClubsList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT * FROM viewclubs";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		UserClubs userClubs;
		
		while(results.next()) {
			userClubs = new UserClubs(results.getString("ClubName"), results.getString("ClubDescription"), results.getString("ContactEmail"),
					results.getInt("ViewClubID"));
			userClubsList.add(userClubs);
		}
		
		return userClubsList;
		
	}
	
	public void displayUserClubs() throws ClassNotFoundException, SQLException {
		ObservableList<UserClubs> list = getUserClubsList();
		colUserClub.setCellValueFactory(new PropertyValueFactory<UserClubs, String>("clubName"));
		colUserClubDescription.setCellValueFactory(new PropertyValueFactory<UserClubs, String>("clubDescription"));
		colUserClubEmail.setCellValueFactory(new PropertyValueFactory<UserClubs, String>("clubEmail"));
		colUserClubId.setCellValueFactory(new PropertyValueFactory<UserClubs, Integer>("tableId"));
		
		userClubsTable.setItems(list);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayUserClubs();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void leaveClub(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM viewclubs WHERE ClubName = 'Coding Enthusiasts'";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		Parent root = FXMLLoader.load(getClass().getResource("UserClubsView.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
