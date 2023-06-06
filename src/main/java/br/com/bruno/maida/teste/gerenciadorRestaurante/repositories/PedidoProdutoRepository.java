package br.com.bruno.maida.teste.gerenciadorRestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {
}