package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

    @Transactional
    @Query(value = "SELECT * FROM endereco WHERE endereco.fk_cliente IN(\n" +
            "SELECT cliente.cliente_id FROM cliente,usuario WHERE cliente.fk_usuario = usuario.usuario_id \n" +
            "AND usuario.email = :email \n" +
            ") ",nativeQuery = true)
    List<Endereco> findUsuarioEmail(@Param("email") String email);


    @Transactional
    @Query(value = "SELECT * FROM endereco WHERE endereco.fk_cliente IN(\n" +
            "SELECT cliente.cliente_id FROM cliente,usuario WHERE cliente.fk_usuario = usuario.usuario_id \n" +
            "AND usuario.email = :email\n" +
            ") AND endereco.endereco_id = :id",nativeQuery = true)
    Endereco findUsuarioEmailById(@Param("email") String email, Integer id, Pageable pageable);

    @Transactional
    @Query(value = "SELECT * FROM endereco",nativeQuery = true)
    List<Endereco> buscarTodos(Pageable pageable);

    @Transactional
    @Query(value = "SELECT * FROM cliente WHERE cliente.fk_usuario IN (\n" +
            "SELECT usuario.usuario_id FROM usuario WHERE usuario.email = :email)",nativeQuery = true)
    Cliente verifyClienteLogado(@Param("email") String email);
}
