package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.CategoriaDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;
    private String descricao;
    private String nome;
    private Double valor;
    private String imagem;
    private CategoriaDto categoria;
}