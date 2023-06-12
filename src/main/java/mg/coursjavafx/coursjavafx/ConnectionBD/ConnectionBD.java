package mg.coursjavafx.coursjavafx.ConnectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBD {

    private static final String username = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/ventevoiturefx";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;
    }
}
