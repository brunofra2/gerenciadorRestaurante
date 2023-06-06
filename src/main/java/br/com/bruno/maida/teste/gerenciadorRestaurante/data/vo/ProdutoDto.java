package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;
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
public class ProdutoDto implements Serializable {
    private Integer id;
    private String descricao;
    private String nome;
    private Double valor;
    private String imagem;
}