package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.CategoriaDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * A DTO for the {@link Produto} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDto implements Serializable {
    @JsonProperty("identificação")
    private Integer id;

    @NotEmpty(message = "O campo 'descrição do produto' é um campo obrigatório")
    @JsonProperty("descrição do produto")
    private String descricao;

    @NotEmpty(message = "O campo 'nome do produto' é um campo obrigatório")
    @JsonProperty("nome do produto")
    private String nome;

    @NotEmpty(message = "O campo 'valor do produto' é um campo obrigatório")
    @JsonProperty("valor do produto")
    private Double valor;

    @JsonProperty("quantidade a ser pedida")
    private Double qtd;

    @NotEmpty(message = "O campo 'imagem do produto' é um campo obrigatório")
    @JsonProperty("imagem do produto")
    private String imagem;

    @NotEmpty(message = "O campo 'categoria do produto' é um campo obrigatório")
    @JsonProperty("categoria do produto")
    private CategoriaDto categoria;
}