package de.edv.model.exception;

public class NorthwindException extends Exception {

    public NorthwindException(String entity, String message) {
        super(entity + ": " + message);
    }
}
