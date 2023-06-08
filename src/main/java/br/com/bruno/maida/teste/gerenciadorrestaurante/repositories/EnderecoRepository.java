package br.com.bruno.maida.teste.gerenciadorrestaurante.repositories;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

    @Transactional
    @Query(value = "SELECT * FROM endereco WHERE fk_cliente = :cliente",nativeQuery = true)
    List<Endereco> findByClient(@Param("cliente") Integer cliente);
}
