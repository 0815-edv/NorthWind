package de.edv.model.exception;

public class ExceptionKino extends Exception {

    public ExceptionKino(String entity, String message) {
        super(entity + ": " + message);
    }
}
