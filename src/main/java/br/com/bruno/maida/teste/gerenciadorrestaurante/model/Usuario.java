package br.com.bruno.maida.teste.gerenciadorrestaurante.model;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "usuario")
@Builder
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nome", length = 45)
    private String name;

    @Column(name = "tipo_usuario")
    private TipoUsuario typeUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(typeUser == TipoUsuario.CLIENTE){
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }else {

            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}