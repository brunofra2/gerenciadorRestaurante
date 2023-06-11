package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
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
 * A DTO for the {@link Endereco} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoDto implements Serializable {
    @JsonProperty("identificação")
    private Integer id;
    @NotEmpty(message = "O campo 'bairro' é um campo obrigatório")
    private String bairro;
    @NotEmpty(message = "O campo 'cep' é um campo obrigatório")
    private String cep;
    @NotEmpty(message = "O campo 'cidade' é um campo obrigatório")
    private String cidade;
    @NotEmpty(message = "O campo 'estado' é um campo obrigatório")
    private String estado;
    @NotEmpty(message = "O campo 'numero' é um campo obrigatório")
    private String numero;
    @NotEmpty(message = "O campo 'pais' é um campo obrigatório")
    private String pais;
    @NotEmpty(message = "O campo 'rua' é um campo obrigatório")
    private String rua;
    @JsonProperty("cliente")
    private ClienteDto fkCliente;
}