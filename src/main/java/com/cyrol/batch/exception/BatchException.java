package com.cyrol.batch.exception;

public class BatchException extends Exception {
    static final long serialVersionUID = 7818375828146090155L;

    public BatchException() {
    }

    public BatchException(String message) {
        super(message);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchException(Throwable cause) {
        super(cause);
    }
}