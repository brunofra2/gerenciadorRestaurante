package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Usuario} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto implements Serializable {
    private Integer id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("senha")
    private String password;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("tipoUsuario")
    private TipoUsuarioDto typeUser;
}