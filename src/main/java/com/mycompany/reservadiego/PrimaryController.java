package com.mycompany.reservadiego;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.mycompany.reservadiego.DAO.ServicioCocinaDAO;
import com.mycompany.reservadiego.Modelo.Evento;
import com.mycompany.reservadiego.Modelo.TipoEvento;
import com.mycompany.reservadiego.Service.CocinaService;

public class PrimaryController {

    @FXML
    private TextField cellphoneInput;
    @FXML
    private CheckBox roomInput;
    @FXML
    private ComboBox<?> cookInput;
    @FXML
    private ComboBox<?> eventTypeInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    private TextField personAmountInput;
    @FXML
    private Label jorunalAmountLabel;
    @FXML
    private TextField journalAmountInput;
    @FXML
    private Button generate;
    @FXML
    private Button clean;
    @FXML
    private Button consult;
    @FXML
    private Button crearContactoButtton;
    @FXML
    private Label unfindLabel;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void generarReserva(ActionEvent event) {
        
        new Evento()
        .setCantidadPersonas(Integer.parseInt(personAmountInput.getText().toString()))
        .setFecha(dateInput.getValue())
        .setFkServicioCocina(CocinaService.obtenerPorNOmbre(cookInput.getValue().toString()))
        .setFkTipoEvento()
        ;
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
    }

    @FXML
    private void consultarReservas(ActionEvent event) {
    }

    @FXML
    private void crearContacto(ActionEvent event) {
    }
}
