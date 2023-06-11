package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {

    @Transactional
    @Query(value = "SELECT produto_pedido.id_produto " +
            "FROM produto_pedido " +
            "WHERE produto_pedido.id_pedido = :id",nativeQuery = true)
    List<Integer> findByIdPedido(@Param("id") Integer id);
    @Transactional
    @Query(value = "SELECT * " +
            "FROM produto_pedido " +
            "WHERE produto_pedido.id_pedido = :id",nativeQuery = true)
    List<ProdutoPedido> findByIdPedidoModel(@Param("id") Integer id);
}