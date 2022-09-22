package application;
//Added in part 2
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UserAccountSettingsController extends UserNavController{
	@FXML
	private Text updateMessage;
	
	public void updateAccount(ActionEvent e) {
		updateMessage.setText("Your changes have been saved.");
	}
}
