package br.com.bruno.maida.teste.gerenciadorRestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {


}
