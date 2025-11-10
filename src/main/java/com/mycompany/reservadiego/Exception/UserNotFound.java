package com.mycompany.reservadiego.Exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
    public UserNotFound() {
      super("Usuario no encontrado");
    }
}
