package com.mycompany.reservadiego.Controllers;

import java.io.IOException;

import com.mycompany.reservadiego.App;
import com.mycompany.reservadiego.Exception.MailAlreadyExists;
import com.mycompany.reservadiego.Exception.NumberAlreadyExist;
import com.mycompany.reservadiego.Servicios.ContactoService;
import com.mycompany.reservadiego.modelos.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField numberInput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField mailInput;
    @FXML
    private Button registrarseButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        try{
            Contacto contacto = new Contacto(0,nameInput.getText(),numberInput.getText(),mailInput.getText());
            new ContactoService().insertContacto(contacto);
            switchToPrimary();
        } catch (MailAlreadyExists m){

        } catch (NumberAlreadyExist n){

        }

    }
}