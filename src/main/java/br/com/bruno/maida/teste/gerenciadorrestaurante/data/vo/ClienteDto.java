package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto implements Serializable {
    private Integer id;
    @JsonProperty("documento")
    private String cpfCnpj;
    @JsonProperty("nome")
    private String name;
    private String telefone;
    @JsonIgnore
    @JsonProperty("usuario")
    private UsuarioDto fkUsuario;
}