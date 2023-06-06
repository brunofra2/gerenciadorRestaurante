package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Pedido} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto implements Serializable {
    private Integer id;
    @JsonProperty("situacao")
    private String status;
    @JsonProperty("valorPedido")
    private Double total;
    @JsonProperty("cliente")
    private ClienteDto fkCliente;
    @JsonProperty("produtos")
    private List<ProdutoDto> produtoDtolist;
}