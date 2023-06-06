package br.com.bruno.maida.teste.gerenciadorRestaurante.model;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.enuns.Categorias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Produto")
@Table(name = "produto")
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id", nullable = false)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "categoria")
    private Categorias categoria;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "produto_pedido",
            joinColumns = { @JoinColumn(name = "id_produto", nullable = false,
                    updatable =  false) }, inverseJoinColumns = {
            @JoinColumn(name = "id_pedido", nullable = false, updatable = false) })
    private List<Pedido> pedidoList;




}