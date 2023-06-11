package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto implements Serializable {
    @JsonProperty("identificação")
    private Integer id;

    @NotEmpty(message = "O campo 'documento do cliente' é um campo obrigatório")
    @JsonProperty("documento do cliente")
    private String cpfCnpj;

    @NotEmpty(message = "O campo 'nome do cliente' é um campo obrigatório")
    @JsonProperty("nome do cliente")
    private String name;

    @NotEmpty(message = "O campo 'telefone para contato' é um campo obrigatório")
    @JsonProperty("telefone para contato")
    private String telefone;

    @NotNull
    @NotEmpty(message = "O campo 'data de nascimento' é um campo obrigatório")
    @JsonProperty("data de nascimento")
    private String nascimento;

    @JsonProperty("usuario")
    private UsuarioDto fkUsuario;
}