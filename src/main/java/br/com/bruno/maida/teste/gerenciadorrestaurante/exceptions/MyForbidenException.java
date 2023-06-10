package br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MyForbidenException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public MyForbidenException(String ex) {
		super(ex);
	}
}