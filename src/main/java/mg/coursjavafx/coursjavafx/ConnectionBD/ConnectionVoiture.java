package mg.coursjavafx.coursjavafx.ConnectionBD;

import mg.coursjavafx.coursjavafx.Models.Voitures.Voitures;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionVoiture {
    public static int create(Voitures voitures) {
        int resVoiture = 0;
        try{
            Connection con = ConnectionBD.connect();
            String sql = "INSERT INTO voitures(matricule, marque_id, nbplace, prix) VALUES (?,?,?,?)";
            PreparedStatement voituresps = con.prepareStatement(sql);
            voituresps.setString(1, voitures.getMatricule());
            voituresps.setInt(2, voitures.getMarque_id());
            voituresps.setInt(3, voitures.getNbplace());
            voituresps.setDouble(4, voitures.getPrix());
            resVoiture = voituresps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resVoiture;
    }
}
