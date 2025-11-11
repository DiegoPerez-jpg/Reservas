module com.mycompany.reservadiego {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires java.desktop;

    opens com.mycompany.reservadiego to javafx.fxml;
    exports com.mycompany.reservadiego;
    exports com.mycompany.reservadiego.Controllers;
    opens com.mycompany.reservadiego.Controllers to javafx.fxml;
}
