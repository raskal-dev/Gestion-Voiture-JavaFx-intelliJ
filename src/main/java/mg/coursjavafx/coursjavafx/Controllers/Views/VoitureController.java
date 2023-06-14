package mg.coursjavafx.coursjavafx.Controllers.Views;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import mg.coursjavafx.coursjavafx.ConnectionBD.ConnectionBD;
import mg.coursjavafx.coursjavafx.ConnectionBD.ConnectionVoiture;
import mg.coursjavafx.coursjavafx.Controllers.FoncionController;
import mg.coursjavafx.coursjavafx.Models.Voitures.Voitures;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VoitureController implements Initializable {
    @FXML
    private FontAwesomeIcon btn_add_voiture;

    @FXML
    private BarChart<?, ?> chart_voiture;

    @FXML
    private Text lbl_count_prix;

    @FXML
    private Text lbl_count_voiture;

    @FXML
    private TextField txtNdplace;

    @FXML
    private TextField txtPrix;

    @FXML
    private ComboBox<String> comboMarque;

    @FXML
    private TableView<Voitures> tb_voiture;

    @FXML
    private AnchorPane voiturepane;

    @FXML
    private TableColumn<Voitures, Integer> id_column;

    @FXML
    private TableColumn<Voitures, String> marque_column;

    @FXML
    private TableColumn<Voitures, String> marticule_column;

    @FXML
    private TableColumn<Voitures, Integer> nbplace_column;

    @FXML
    private TableColumn<Voitures, Double> prix_column;

    public ObservableList<Voitures> donnee = FXCollections.observableArrayList();

    @FXML
    void abbVoitureClicked(MouseEvent event) {

        String matricule = FoncionController.genererNumero(6);
        String marque = comboMarque.getValue();
        int nbplace = Integer.parseInt(txtNdplace.getText());
        double prix = Double.parseDouble(txtPrix.getText());

        Voitures v = new Voitures();
        v.setMatricule(matricule);
        v.setMarque(marque);
        v.setNbplace(nbplace);
        v.setPrix(prix);

        int status = ConnectionVoiture.createVoiture(v);

        if (status > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout Voiture");
            alert.setHeaderText("Information");
            alert.setContentText("Voiture bien Ajouter !");
            alert.showAndWait();

            comboMarque.getItems().clear();
            donnee.clear();

            tableauVoiture();
            listMarque();
            countVoiture();
            countPrix();
            videChamp();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Voiture");
            alert.setHeaderText("Information");
            alert.setContentText("Voiture n'est pas ajouter !");
            alert.showAndWait();
        }

    }

    void videChamp() {
        txtNdplace.setText("");
        txtPrix.setText("");
    }

    void tableauVoiture() {
        try {
            Connection conn = ConnectionBD.connect();
            String sql_select = "SELECT * FROM voitures";
            PreparedStatement stat = conn.prepareStatement(sql_select);
            ResultSet rs_querry = stat.executeQuery();
            while (rs_querry.next()) {
                donnee.add(new Voitures(rs_querry.getInt(1), rs_querry.getString(2), rs_querry.getString(3), rs_querry.getInt(4), rs_querry.getDouble(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        id_column.setCellValueFactory(new PropertyValueFactory<Voitures, Integer>("id"));
        marticule_column.setCellValueFactory(new PropertyValueFactory<Voitures, String>("matricule"));
        marque_column.setCellValueFactory(new PropertyValueFactory<Voitures, String>("marque"));
        nbplace_column.setCellValueFactory(new PropertyValueFactory<Voitures, Integer>("nbplace"));
        prix_column.setCellValueFactory(new PropertyValueFactory<Voitures, Double>("prix"));
        tb_voiture.setItems(donnee);
    }

    void listMarque() {
        try {
            Connection conn = ConnectionBD.connect();
            String sql_marque = "SELECT marque FROM marques";
            PreparedStatement statMarque = conn.prepareStatement(sql_marque);
            ResultSet rs_marque = statMarque.executeQuery();
            while (rs_marque.next()) {
                String maqure_azo = rs_marque.getString("marque");
                comboMarque.getItems().add(maqure_azo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void countVoiture() {
        try {
            Connection conn = ConnectionBD.connect();
            String sql = "SELECT count(*) AS countv FROM voitures";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int compte = rs.getInt("countv");
                lbl_count_voiture.setText(String.valueOf(compte));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void countPrix() {
        try {
            Connection conn = ConnectionBD.connect();
            String sql = "SELECT sum(prix) AS countp FROM voitures";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int compte = rs.getInt("countp");
                lbl_count_prix.setText(String.valueOf(compte));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableauVoiture();
        listMarque();
        countVoiture();
        countPrix();
    }
}
