package br.com.bruno.maida.teste.gerenciadorrestaurante.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Pedido")
@Table(name = "pedido")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id", nullable = false)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente fkCliente;

    @ManyToMany(mappedBy = "pedidoList",fetch = FetchType.LAZY)
    private List<Produto> produtoList;

}