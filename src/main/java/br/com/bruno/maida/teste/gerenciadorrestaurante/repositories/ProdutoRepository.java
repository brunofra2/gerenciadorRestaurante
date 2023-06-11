package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {


    @Transactional
    @Query(value = "SELECT * FROM produto WHERE produto.produto_id IN(SELECT produto_pedido.id_produto \n" +
            "            FROM produto_pedido \n" +
            "            WHERE produto_pedido.id_pedido = 10)",nativeQuery = true)
    List<Produto> findByPedido(@Param("id") Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM produto",nativeQuery = true)
    List<Produto> buscarTodos(Pageable pageable);

}
