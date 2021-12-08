package com.example.sicred.web.rest.exceptions;

public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = -1692226385434246053L;

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
