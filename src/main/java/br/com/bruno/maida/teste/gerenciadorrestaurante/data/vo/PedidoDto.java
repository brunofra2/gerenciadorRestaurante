package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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