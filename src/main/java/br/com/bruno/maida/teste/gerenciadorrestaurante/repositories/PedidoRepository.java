package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    @Transactional
    @Query(value = "SELECT * FROM pedido WHERE pedido.fk_cliente IN(\n" +
            "SELECT cliente.cliente_id FROM cliente,usuario WHERE cliente.fk_usuario = usuario.usuario_id \n" +
            "AND usuario.email = :email \n" +
            ")",nativeQuery = true)
    List<Pedido> findUsuarioEmail(@Param("email") String email);

    @Transactional
    @Query(value = "SELECT * FROM pedido WHERE pedido.fk_cliente IN(\n" +
            "SELECT cliente.cliente_id FROM cliente,usuario WHERE cliente.fk_usuario = usuario.usuario_id \n" +
            "AND usuario.email = :email \n" +
            ") AND pedido.pedido_id = :id",nativeQuery = true)
    Pedido findUsuarioEmailByid(@Param("email") String email,@Param("id") Integer id);

}
