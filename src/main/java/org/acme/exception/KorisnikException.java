package org.acme.exception;

public class KorisnikException extends Exception {

    private static final long serialVersionUID = 1L;

    public KorisnikException(String message) {
        super(message);
    }
}