package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Endereco} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoDto implements Serializable {
    private Integer id;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String numero;
    private String pais;
    private String rua;
    @JsonIgnore
    @JsonProperty("cliente")
    private ClienteDto fkCliente;
}