package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Transactional
    @Query(value = "SELECT * FROM cliente WHERE cliente.fk_usuario = :usuario_id",nativeQuery = true)
    Cliente verifyDuplicidade(@Param("usuario_id") Integer id);

    @Transactional
    @Query(value = "SELECT * FROM cliente WHERE cliente.fk_usuario IN (\n" +
            "SELECT usuario.usuario_id FROM usuario WHERE usuario.email = :email)",nativeQuery = true)
    Cliente verifyClienteLogado(@Param("email") String email);
}
