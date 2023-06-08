package br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MyRunTimeException extends java.lang.Exception {

    private static final long serialVersionUID = 1L;

    public MyRunTimeException(String ex) {
        super(ex);
    }

    public MyRunTimeException(String ex, Throwable cause) {
        super(ex, cause);
    }
}
