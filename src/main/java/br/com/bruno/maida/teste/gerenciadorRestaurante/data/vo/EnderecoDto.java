package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Endereco;
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
public class EnderecoDto implements Serializable {
    private Integer id;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String numero;
    private String pais;
    private String rua;
    @JsonProperty("cliente")
    private ClienteDto fkCliente;
}