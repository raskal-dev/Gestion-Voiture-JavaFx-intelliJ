module mg.coursjavafx.coursjavafx {
    requires transitive java.sql;
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires fontawesomefx;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens mg.coursjavafx.coursjavafx to javafx.fxml;
    opens mg.coursjavafx.coursjavafx.Models.Voitures to javafx.base, javafx.graphics;
    opens mg.coursjavafx.coursjavafx.fxml to javafx.fxml;
    opens mg.coursjavafx.coursjavafx.img to javafx.fxml;
    opens mg.coursjavafx.coursjavafx.style to javafx.fxml;
    opens mg.coursjavafx.coursjavafx.Controllers to javafx.fxml, javafx.graphics;
    opens mg.coursjavafx.coursjavafx.Controllers.Views to javafx.fxml, javafx.graphics;
    exports mg.coursjavafx.coursjavafx;
}