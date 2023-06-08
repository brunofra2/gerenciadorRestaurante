package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
