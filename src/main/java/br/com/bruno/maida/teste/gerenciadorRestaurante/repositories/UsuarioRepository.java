package br.com.bruno.maida.teste.gerenciadorRestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT obj FROM Usuario obj WHERE obj.email = :email " +
            "and obj.password = :senha")
    Usuario findUsuario(@Param("email") String email,
                               @Param("senha") String senha);
}
