package br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("data e Hora")
	private Date timestamp;

	private String status;
	@JsonProperty("Mensagem do erro")
	private String message;
	@JsonProperty("detalhes")
	private String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getStatus(){return status;}
}
