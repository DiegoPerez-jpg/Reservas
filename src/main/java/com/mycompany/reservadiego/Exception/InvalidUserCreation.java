package com.mycompany.reservadiego.Exception;

public class InvalidUserCreation extends RuntimeException {
    public InvalidUserCreation(String message) {
        super(message);
    }
}
