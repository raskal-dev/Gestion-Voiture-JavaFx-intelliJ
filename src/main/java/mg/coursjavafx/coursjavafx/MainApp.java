package mg.coursjavafx.coursjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Login.fxml"));

        primaryStage.setTitle("Andrana");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
