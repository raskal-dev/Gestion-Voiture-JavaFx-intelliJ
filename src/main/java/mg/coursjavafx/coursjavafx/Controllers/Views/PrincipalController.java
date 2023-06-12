package mg.coursjavafx.coursjavafx.Controllers.Views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    @FXML
    private HBox hb_commande;

    @FXML
    private HBox hb_home;

    @FXML
    private HBox hb_statistique;

    @FXML
    private HBox hb_voiture;

    @FXML
    private Label lbl_commande;

    @FXML
    private Label lbl_statistique;

    @FXML
    private Label lbl_voiture;

    @FXML
    private AnchorPane rootPane;

    @FXML
    void commandeClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Commande.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void homeClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Home.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void statistiqueClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Statistique.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void voitureClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Voiture.fxml"));
        rootPane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/mg/coursjavafx/coursjavafx/fxml/Home.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rootPane.getChildren().setAll(pane);
    }
}
