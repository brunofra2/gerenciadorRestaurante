package br.com.bruno.maida.teste.gerenciadorRestaurante.model;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.enuns.TipoUsuario;
import lombok.*;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "usuario")
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nome", length = 45)
    private String name;

    @Column(name = "tipo_usuario")
    private TipoUsuario typeUser;



}