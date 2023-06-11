package br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.SituacoesDto;
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
    @JsonProperty("identificação")
    private Integer id;
    @JsonProperty("situação")
    private SituacoesDto status;
    @JsonProperty("valor do pedido")
    private Double total;
    @JsonProperty("informações cliente")
    private ClienteDto fkCliente;
    @JsonProperty("listagem de produtos")
    private List<ProdutoDto> produtoDtolist;
}