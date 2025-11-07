module com.mycompany.reservadiego {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.reservadiego to javafx.fxml;
    exports com.mycompany.reservadiego;
}
