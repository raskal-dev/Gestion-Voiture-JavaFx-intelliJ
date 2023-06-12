package mg.coursjavafx.coursjavafx.Controllers.Views;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import mg.coursjavafx.coursjavafx.ConnectionBD.ConnectionBD;
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
    private Text lbl_count_voiture;

    @FXML
    private TextField marque;

    @FXML
    private TextField ndplace;

    @FXML
    private TextField prix;

    @FXML
    private TableView<Voitures> tb_voiture;

    @FXML
    private AnchorPane voiturepane;

    @FXML
    private TableColumn<Voitures, Integer> id_column;

    @FXML
    private TableColumn<Voitures, Integer> marque_column;

    @FXML
    private TableColumn<Voitures, String> marticule_column;

    @FXML
    private TableColumn<Voitures, Integer> nbplace_column;

    @FXML
    private TableColumn<Voitures, Double> prix_column;

    public ObservableList<Voitures> donnee = FXCollections.observableArrayList();

    @FXML
    void abbVoitureClicked(MouseEvent event) throws SQLException {
        Connection con = ConnectionBD.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO voitures(marque_id, nbplace, prix) VALUES(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, marque.getText());
            pst.setString(2, ndplace.getText());
            pst.setString(3, prix.getText());
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tableauVoiture() {
        try {
            Connection conn = ConnectionBD.connect();
            String sql_select = "SELECT * FROM voitures";
            PreparedStatement stat = conn.prepareStatement(sql_select);
            ResultSet rs_querry = stat.executeQuery();
            while (rs_querry.next()) {
                donnee.add(new Voitures(rs_querry.getInt(1), rs_querry.getString(2), rs_querry.getInt(3), rs_querry.getInt(4), rs_querry.getDouble(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        id_column.setCellValueFactory(new PropertyValueFactory<Voitures, Integer>("id"));
        marticule_column.setCellValueFactory(new PropertyValueFactory<Voitures, String>("matricule"));
        marque_column.setCellValueFactory(new PropertyValueFactory<Voitures, Integer>("marque_id"));
        nbplace_column.setCellValueFactory(new PropertyValueFactory<Voitures, Integer>("nbplace"));
        prix_column.setCellValueFactory(new PropertyValueFactory<Voitures, Double>("prix"));
        tb_voiture.setItems(donnee);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableauVoiture();

    }
}
