package mg.coursjavafx.coursjavafx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mg.coursjavafx.coursjavafx.ConnectionBD.ConnectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private PasswordField inputpassword;

    @FXML
    private TextField inputusername;

    @FXML
    private Label labelres;

    @FXML
    void btnLogin(ActionEvent event) throws SQLException {
        Connection con = ConnectionBD.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, inputusername.getText().toString());
            ps.setString(2, inputpassword.getText().toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                Stage stage = new Stage();
                Parent parent = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Principal.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("HOME");
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erreur de connexion !");
                alert.setTitle("ERREUR");
                alert.setContentText("Votre username ou password sont incorrectes \nVeuillez verifiez svp !");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
