package br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class Exception extends java.lang.Exception {

    private static final long serialVersionUID = 1L;

    public Exception(String ex) {
        super(ex);
    }

    public Exception(String ex, Throwable cause) {
        super(ex, cause);
    }
}
