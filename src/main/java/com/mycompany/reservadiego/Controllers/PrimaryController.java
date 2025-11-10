package com.mycompany.reservadiego.Controllers;

import java.io.IOException;

import com.mycompany.reservadiego.App;
import com.mycompany.reservadiego.DAOS.DAOCongreso;
import com.mycompany.reservadiego.Exception.UserNotFound;
import com.mycompany.reservadiego.Servicios.CocinaService;
import com.mycompany.reservadiego.Servicios.CongresoService;
import com.mycompany.reservadiego.Servicios.EventoService;
import com.mycompany.reservadiego.Servicios.TipoeventoService;
import com.mycompany.reservadiego.conexion.Conexion;
import com.mycompany.reservadiego.modelos.Cocina;
import com.mycompany.reservadiego.modelos.Congreso;
import com.mycompany.reservadiego.modelos.Tipoevento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PrimaryController {

    @FXML
    private TextField cellphoneInput;
    @FXML
    private CheckBox roomInput;
    @FXML
    private ComboBox<String> cookInput;
    @FXML
    private ComboBox<String> eventTypeInput;
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

    @FXML
    private void limpiarCampos(ActionEvent event) {
        cellphoneInput.setText("");
        journalAmountInput.setText("");
        cellphoneInput.setText("");
        personAmountInput.setText("");
        dateInput.setValue(null);
        roomInput.setSelected(false);

    }
    private void switchToSecondary() throws IOException {
    }

    private void añadirAComboBox(ComboBox<String> comboBox,ArrayList<String> elementos){
        ObservableList<String> opciones = FXCollections.observableArrayList(elementos);
        comboBox.setItems(opciones);

        if (!opciones.isEmpty()) {
            comboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    public void initialize(){
        Conexion.getConnection();
        jorunalAmountLabel.setVisible(false);
        journalAmountInput.setVisible(false);
        unfindLabel.setVisible(false);
        crearContactoButtton.setVisible(false);
        añadirAComboBox(eventTypeInput,new TipoeventoService().getNombres());
        añadirAComboBox(cookInput,new CocinaService().getNombres());
    }

    @FXML
    private void generarReserva(ActionEvent event) {
        Tipoevento tipoevento = new TipoeventoService().getTipoEventoByNombre(eventTypeInput.getValue().toString());
        if(tipoevento.getTipoevento().equals("Congreso") && journalAmountInput.getText().isEmpty()){
            jorunalAmountLabel.setVisible(true);
            journalAmountInput.setVisible(true);
            return;
        }
        System.out.println("xdddddd");
        Cocina cocina = new CocinaService().getCocinaByNombre(cookInput.getValue().toString());
        try{
            new EventoService().crearEvento(cellphoneInput.getText(),
                    dateInput.getValue(),
                    tipoevento,
                    Integer.parseInt(personAmountInput.getText()),
                    cocina,
                    roomInput.isSelected());
            if(tipoevento.getTipoevento().equals("Congreso")){
                new CongresoService().insertCongreso(Integer.parseInt(jorunalAmountLabel.getText()));
            }
        } catch (UserNotFound u){
            unfindLabel.setVisible(true);
            crearContactoButtton.setVisible(true);
        } catch (NumberFormatException n){
            System.out.println("No campos vacios porfis");
        }


    }


    @FXML
    private void consultarReservas(ActionEvent event) {
    }

    @FXML
    private void crearContacto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void comboBoxCambiado(ActionEvent actionEvent) {
        if(eventTypeInput.getValue().equals("Congreso")){
            jorunalAmountLabel.setVisible(true);
            journalAmountInput.setVisible(true);
            return;
        }
        jorunalAmountLabel.setVisible(false);
        journalAmountInput.setVisible(false);

    }
}
