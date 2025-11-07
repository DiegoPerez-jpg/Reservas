module com.mycompany.reservadiego {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.reservadiego to javafx.fxml;
    exports com.mycompany.reservadiego;
}
