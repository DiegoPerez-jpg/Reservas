package com.mycompany.reservadiego.Exception;

public class MailAlreadyExists extends RuntimeException {
    public MailAlreadyExists(String message) {
        super(message);
    }
}
