package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM cliente WHERE cliente.fk_usuario = :usuario_id",nativeQuery = true)
    Cliente verifyDuplicidade(@Param("usuario_id") Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM cliente",nativeQuery = true)
    List<Cliente> buscarTodos(Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM cliente WHERE cliente.fk_usuario IN (\n" +
            "SELECT usuario.usuario_id FROM usuario WHERE usuario.email = :email)",nativeQuery = true)
    Cliente verifyClienteLogado(@Param("email") String email);
}
