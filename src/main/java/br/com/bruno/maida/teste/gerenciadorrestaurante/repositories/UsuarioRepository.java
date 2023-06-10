package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Transactional
    @Query(value = "SELECT obj FROM Usuario obj WHERE obj.email = :email " +
            "")
    Usuario findUsuario(@Param("email") String email);

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM usuario WHERE usuario.tipo_usuario = 0",nativeQuery = true)
    Integer findCount();
}
