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

public class AdminManageMembersController extends AdminNavController implements Initializable{
	// Fields for the Manage Members table
	@FXML 
	private TableView<Members> manageMembersTable;
	@FXML
	private TableColumn<Members, String> colMembersClub;
	@FXML
	private TableColumn<Members, Integer> colMembersStudentId;
	@FXML
	private TableColumn<Members, String> colMembersName;
	@FXML
	private TableColumn<Members, String> colMembersEmail;
	@FXML
	private TableColumn<Members, Integer> colMembersId;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Methods for loading data from MySQL database into the members table
	
	public ObservableList<Members> getMembersList() throws ClassNotFoundException, SQLException {
		ObservableList<Members> membersList = FXCollections.observableArrayList();
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		String sqlQuery = "SELECT * FROM manageclubmembers";
		Statement statement;
		ResultSet results;
		
		statement = connection.createStatement();
		results = statement.executeQuery(sqlQuery);
		Members members;
		
		while(results.next()) {
			members = new Members(results.getString("Club Name"), results.getInt("StudentID"), results.getString("MemberName"), 
					results.getString("ContactEmail"), results.getInt("ManageClubMembersID"));
			membersList.add(members);
		}
		
		return membersList;
		
	}
	public void displayMembers() throws ClassNotFoundException, SQLException {
		ObservableList<Members> list = getMembersList();
		colMembersClub.setCellValueFactory(new PropertyValueFactory<Members, String>("clubName"));
		colMembersStudentId.setCellValueFactory(new PropertyValueFactory<Members, Integer>("studentId"));
		colMembersName.setCellValueFactory(new PropertyValueFactory<Members, String>("memberName"));
		colMembersEmail.setCellValueFactory(new PropertyValueFactory<Members, String>("contactEmail"));
		colMembersId.setCellValueFactory(new PropertyValueFactory<Members, Integer>("memberId"));
		
		manageMembersTable.setItems(list);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayMembers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		String sqlQuery = "DELETE FROM manageclubmembers WHERE ManageClubMembersID = 10";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlQuery);
		
		String sqlQuery2 = "UPDATE manageclubs SET NoMembers = 2 WHERE ManageClubID = 7";
		Statement statement2 = connection.createStatement();
		statement2.executeUpdate(sqlQuery2);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminManageMembers.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
		
}
