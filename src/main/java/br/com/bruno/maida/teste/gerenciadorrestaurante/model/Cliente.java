package br.com.bruno.maida.teste.gerenciadorrestaurante.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer id;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "name")
    private String name;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private String nascimento;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario fkUsuario;


}