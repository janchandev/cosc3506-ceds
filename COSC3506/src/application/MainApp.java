package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage) {
        MainApp.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return MainApp.primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
    	System.out.println(getClass());
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Login.fxml"));
        stage.setTitle("User Registration");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
