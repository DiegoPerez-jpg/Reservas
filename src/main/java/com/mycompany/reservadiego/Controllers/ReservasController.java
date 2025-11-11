/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.reservadiego.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.reservadiego.DAOS.DAOEvento;
import com.mycompany.reservadiego.DTO.EventoCompletoDTO;
import com.mycompany.reservadiego.Servicios.EventoService;
import com.mycompany.reservadiego.modelos.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author m
 */
public class ReservasController implements Initializable {

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
        // TODO

        actualizeTabla();
    }

    public void actualizeTabla(){
        int numero = numeroInput.getText().isEmpty() ? 0 : Integer.parseInt(numeroInput.getText());
        int personas = personasInput.getText().isEmpty() ? 0 : Integer.parseInt(personasInput.getText());
        int jornadas = jornadasInput.getText().isEmpty() ? 0 : Integer.parseInt(jornadasInput.getText());

        Object[] resultados = new EventoService().getEventosCompletos(
                nombreInput.getText(),
                mailInput.getText(),
                numero,
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
    private void switchToInit(ActionEvent event) {
    }

    @FXML
    private void anularEvento(ActionEvent event) {
        int selectedIndex = EventosCompletosTable.getSelectionModel().getSelectedIndex();
        new EventoService().cancelarReserva(ids.get(selectedIndex));
    }

    @FXML
    private void aplicarFiltros(ActionEvent event) {
        actualizeTabla();
    }
    
}
