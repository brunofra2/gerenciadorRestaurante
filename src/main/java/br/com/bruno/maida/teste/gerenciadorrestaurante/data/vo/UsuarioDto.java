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

import javax.validation.constraints.NotEmpty;
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

    @JsonProperty("identificação")
    private Integer id;

    @NotEmpty(message = "O campo 'email para acesso' é um campo obrigatório")
    @JsonProperty("email para acesso")
    private String email;

    @NotEmpty(message = "O campo 'senha de acesso' é um campo obrigatório")
    @JsonProperty("senha de acesso")
    private String password;

    @NotEmpty(message = "O campo 'nome usuario ou estabelecimento' é um campo obrigatório")
    @JsonProperty("nome usuario ou estabelecimento")
    private String name;

    @JsonProperty("permissão de acesso")
    private TipoUsuarioDto typeUser;
}