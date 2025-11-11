/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reservadiego.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.reservadiego.App;
import com.mycompany.reservadiego.DAOS.DAOEvento;
import com.mycompany.reservadiego.DTO.EventoCompletoDTO;
import com.mycompany.reservadiego.Servicios.EventoService;
import com.mycompany.reservadiego.modelos.Evento;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author m
 */
public class ReservasController implements Initializable {

    @FXML
    private TableColumn<EventoCompletoDTO, String> colNumeroTelefono;
    @FXML
    private TableColumn<EventoCompletoDTO, String> colCorreoElectronico;
    @FXML
    private TableColumn<EventoCompletoDTO, String> colNombreCompleto;
    @FXML
    private TableColumn<EventoCompletoDTO, String> colTipoEvento;
    @FXML
    private TableColumn<EventoCompletoDTO, String> colCocina;
    @FXML
    private TableColumn<EventoCompletoDTO, Boolean> colRequiereHabitaciones;
    @FXML
    private TableColumn<EventoCompletoDTO, Integer> colNumeroPersonas;
    @FXML
    private TableColumn<EventoCompletoDTO, Integer> colNumeroJornadas;
    @FXML
    private Button anularButton;
    @FXML
    private Button aplicarButton;
    @FXML
    private TextField numeroInput;
    @FXML
    private TextField mailInput;
    @FXML
    private TextField nombreInput;
    @FXML
    private TextField tipoInput;
    @FXML
    private TextField cocinaInput;
    @FXML
    private CheckBox requiereInput;
    @FXML
    private TextField personasInput;
    @FXML
    private TextField jornadasInput;
    @FXML
    private TableView<EventoCompletoDTO> EventosCompletosTable;

    private ArrayList<Integer> ids;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNombreCompleto.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNombreCompleto()));
        colNumeroTelefono.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNumeroTelefono()));
        colCorreoElectronico.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getCorreoElectronico()));
        colTipoEvento.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getTipoEvento()));
        colCocina.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getCocina()));
        colNumeroPersonas.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getNumeroPersonas()));
        colRequiereHabitaciones.setCellValueFactory(c -> new ReadOnlyObjectWrapper(c.getValue().isRequiereHabitaciones() ? "Sí" : "No"));
        colNumeroJornadas.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getJornadas()));

        actualizeTabla();
    }

    public void actualizeTabla(){
        int personas = personasInput.getText().isEmpty() ? 0 : Integer.parseInt(personasInput.getText());
        int jornadas = jornadasInput.getText().isEmpty() ? 0 : Integer.parseInt(jornadasInput.getText());

        Object[] resultados = new EventoService().getEventosCompletos(
                nombreInput.getText(),
                mailInput.getText(),
                numeroInput.getText(),
                cocinaInput.getText(),
                tipoInput.getText(),
                requiereInput.isSelected(),
                personas,
                jornadas
        );
        ArrayList<EventoCompletoDTO> lista = (ArrayList<EventoCompletoDTO>) resultados[0];
        this.ids = (ArrayList<Integer>) resultados[1];
        if(lista==null)return;


        ObservableList<EventoCompletoDTO> datos = FXCollections.observableArrayList(lista);

        EventosCompletosTable.setItems(datos);
    }

    @FXML
    private void switchToInit(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(640);
        stage.setHeight(480);
        App.setRoot("primary");

    }

    @FXML
    private void anularEvento(ActionEvent event) {
        int selectedIndex = EventosCompletosTable.getSelectionModel().getSelectedIndex();
        new EventoService().cancelarReserva(ids.get(selectedIndex));
        actualizeTabla();
    }

    @FXML
    private void aplicarFiltros(ActionEvent event) {
        actualizeTabla();
    }
    
}
