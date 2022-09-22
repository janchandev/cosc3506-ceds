package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterController {
    
    @FXML
    private TextField fullNameField;
    
    @FXML
    private TextField emailIdField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button submitButton;

    @FXML
    private TextField studentId;

    /**
     * CREATE CLUB
     *
     * */

    @FXML
    private TextField clubName;
    @FXML
    private TextField clubEmail;
    @FXML
    private TextField clubPrice;
    @FXML
    private TextArea clubDescription;

    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {
    
    	Window owner = submitButton.getScene().getWindow();

//    	System.out.println(fullNameField.getText());
//    	System.out.println(emailIdField.getText());
//    	System.out.println(passwordField.getText());
//        System.out.println(studentId.getText());
    	if(fullNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your name");
            return;
        }
    	
    	if(emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a password");
            return;
        }
        
    	String fullName = fullNameField.getText();
    	String emailId = emailIdField.getText();
    	String password = passwordField.getText();
        String student = studentId.getText();
    	
    	JdbcDao jdbcDao = new JdbcDao();
    	jdbcDao.insertRecord(fullName, emailId, password,student);
    	
    	showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
                "Welcome " + fullNameField.getText());
        switchToLogin(event);
    }
    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void changeToSignUpPage(ActionEvent actionEvent) throws IOException {
        Stage stage = MainApp.getPrimaryStage();
        System.out.println(getClass());
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserRegistration.fxml"));
        stage.setTitle("User Registration");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = MainApp.getPrimaryStage();
        System.out.println(getClass());
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Login.fxml"));
        stage.setTitle("User Login");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }


    public  Window getOwner(ActionEvent actionEvent){
        return  ((Node) actionEvent.getTarget()).getScene().getWindow();
    }

    public void processLogin(ActionEvent actionEvent) throws IOException {

        Window owner = getOwner(actionEvent);


        if(emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        boolean checkLogin = jdbcDao.checkLogin(emailId, password);
        
        if(emailId.equals("admin@gmail.com") && password.equals("adminpassword")) {
        	showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!",
                    "Welcome to Dashboard");
            LoadNewPage("AdminManageClubs.fxml");
        }

        else if(checkLogin){
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!",
                    "Welcome to Dashboard");
            LoadNewPage("UserClubsView.fxml");
        }
        else{
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Failed!",
                    "Email / Password is incorrect");
        }
    }

    public void createClub(ActionEvent actionEvent) {
        Window owner = getOwner(actionEvent);
        JdbcDao jdbcDao = new JdbcDao();
        String name = clubName.getText();
        String email = clubEmail.getText();
        String price = clubPrice.getText();
        String description = clubDescription.getText();


        if(name.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a  club name");
            return;
        }
        if(email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a  club email");
            return;
        }

        if(price.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a  club membership price");
            return;
        }
        if(description.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a  club description");
            return;
        }

        jdbcDao.createClub(name, email, description,price);

        clubName.setText("");
        clubEmail.setText("");
        clubDescription.setText("");
        clubPrice.setText("");

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Club Created!",
                "Yeah! Club created successfully with name : "+name);


    }

    private void LoadNewPage(String s) throws IOException {
        Stage stage = MainApp.getPrimaryStage();
        System.out.println(getClass());
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(s));
        stage.setTitle(s);
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public void switchToManageClubs(ActionEvent actionEvent) throws IOException {
        LoadNewPage("AdminManageClubs.fxml");
    }

    public void switchToCreateClubs(ActionEvent actionEvent) throws IOException {
        LoadNewPage("AdminCreateClubs.fxml");
    }


    public void switchToManageEvents(ActionEvent actionEvent) throws IOException {
        LoadNewPage("AdminManageEvents.fxml");
    }

    public void switchToCreateEvents(ActionEvent actionEvent) throws IOException {
        LoadNewPage("AdminCreateEvent.fxml");
    }


    public void createEvent(ActionEvent actionEvent) {
        System.out.println("Create Event called");
    }
}
