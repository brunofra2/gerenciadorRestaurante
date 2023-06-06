package br.com.bruno.maida.teste.gerenciadorRestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.ProdutoPedido;
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
}