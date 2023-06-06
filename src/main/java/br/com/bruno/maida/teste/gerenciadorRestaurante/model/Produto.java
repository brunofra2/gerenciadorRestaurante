package br.com.bruno.maida.teste.gerenciadorRestaurante.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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



}