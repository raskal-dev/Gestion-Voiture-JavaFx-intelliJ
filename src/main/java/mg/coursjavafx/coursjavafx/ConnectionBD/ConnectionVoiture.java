package mg.coursjavafx.coursjavafx.ConnectionBD;

import mg.coursjavafx.coursjavafx.Models.Voitures.Voitures;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionVoiture {
    public static int createVoiture(Voitures voitures) {
        int resVoiture = 0;
        try{
            Connection con = ConnectionBD.connect();
            String sql = "INSERT INTO voitures(matricule, marque, nbplace, prix) VALUES (?,?,?,?)";
            assert con != null;
            PreparedStatement voituresps = con.prepareStatement(sql);
            voituresps.setString(1, voitures.getMatricule());
            voituresps.setString(2, voitures.getMarque());
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
