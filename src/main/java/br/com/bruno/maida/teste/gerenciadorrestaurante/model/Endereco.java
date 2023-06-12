package br.com.bruno.maida.teste.gerenciadorrestaurante.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Endereco")
@Table(name = "endereco")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private Integer id;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero")
    private String numero;

    @Column(name = "pais")
    private String pais;

    @Column(name = "rua")
    private String rua;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente fkCliente;
}