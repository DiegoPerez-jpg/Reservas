package com.mycompany.reservadiego.Controllers;

import com.mycompany.reservadiego.Exception.InvalidUserCreation;
import com.mycompany.reservadiego.modelos.Contacto;

public class ContactoController {

    public Contacto crearContacto(String nombreCompleto, String numeroTelefono, String correoElectronico) throws InvalidUserCreation {

        if(nombreCompleto.isEmpty())throw new InvalidUserCreation("El campo nombre no puede estar vacio");
        if(!nombreCompleto.matches("^[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+$"))throw  new InvalidUserCreation("El campo nombre debe seguir el formado Nombre Apellido Apellido2");
        if(numeroTelefono.isEmpty())throw new InvalidUserCreation("El campo Numero de telefono no puede estar vacio");
        if(!numeroTelefono.matches("^\\+34 ?[6-9]\\d{2} ?\\d{3} ?\\d{3}$"))throw new InvalidUserCreation("El campo numero de telefono debe seguir el formato +34 999 999 999");
        if(correoElectronico.isEmpty())throw new InvalidUserCreation("El campo Correo electronico no puede estar vacio");
        if(!correoElectronico.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))throw new InvalidUserCreation("El campo Correo electronico debe seguir el formato usuario123@mail.co");

        return new Contacto(0,nombreCompleto,numeroTelefono,correoElectronico);
    }
}
