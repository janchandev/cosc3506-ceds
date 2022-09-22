package application;
//Added in part 2
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserJoinClubsController extends UserNavController implements Initializable{
	@FXML
	private ChoiceBox<String> joinClubMenu;
	@FXML
	private Text joinClubName;
	@FXML
	private TextArea joinClubDescription;
	@FXML
	private TextArea joinClubEmail;
	@FXML
	private Text joinClubPrice;
	private String[] clubs = {"Coding Enthusiasts", "Gold Gamers"};
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void showClubInfo(ActionEvent e) {
		String clubChoice = joinClubMenu.getValue();
		
		if (clubChoice.equals("Coding Enthusiasts")) {
			joinClubName.setText(clubChoice);
			joinClubDescription.setText("A club for all coding enthusiasts from beginner to advanced! Come learn and meet other coding enthusiasts!");
			joinClubEmail.setText("codingenthusiasts@gmail.com");
			joinClubPrice.setText("125");
		}
		
		else if (clubChoice.equals("Gold Gamers")) {
			joinClubName.setText(clubChoice);
			joinClubDescription.setText("Take a break from your studies and join other students who love to game!");
			joinClubEmail.setText("goldgamers@gmail.com");
			joinClubPrice.setText("150");
		}
	}
	
	public void joinClub(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserPayment.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		joinClubMenu.getItems().addAll(clubs);
		joinClubMenu.setOnAction(this::showClubInfo);
		
	}

}
