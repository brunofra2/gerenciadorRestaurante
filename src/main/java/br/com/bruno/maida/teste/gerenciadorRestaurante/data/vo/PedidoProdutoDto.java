package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.PedidoProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link PedidoProduto} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoProdutoDto implements Serializable {
    private Integer id;
    private PedidoDto pedido;
    private ProdutoDto produto;
}