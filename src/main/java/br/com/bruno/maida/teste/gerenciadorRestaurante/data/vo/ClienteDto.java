package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Cliente;
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
public class ClienteDto implements Serializable {
    private Integer id;
    @JsonProperty("documento")
    private String cpfCnpj;
    @JsonProperty("nome")
    private String name;
    private String telefone;
    @JsonProperty("usuario")
    private UsuarioDto fkUsuario;
}