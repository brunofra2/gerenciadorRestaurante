package br.com.bruno.maida.teste.gerenciadorrestaurante.services;


import br.com.bruno.maida.teste.gerenciadorrestaurante.UtilsTest.Constantes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.CategoriaDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.Categorias;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.Situacoes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.ProdutoServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("teste do service - Produto Service")
public class ProdutoServiceImplTest {


    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    PageRequest pageRequest;

    @InjectMocks
    private ProdutoServiceImpl produtoService;


    @Test
    public void testarBuscarTodos(){
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        pageRequest = PageRequest.of(page -1,pageSize);
        List<Produto> list = List.of(criacao());
        Mockito.when(produtoRepository.buscarTodos(pageRequest))
                .thenReturn(list);
        produtoService.findall(page,pageSize);
        Mockito.verify(produtoRepository).buscarTodos(pageRequest);
    }

    @Test
    public void testarBuscarPorId(){

        Mockito.when(produtoRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(criacao()));
        produtoService.findById(Mockito.any());
        Mockito.verify(produtoRepository).findById(Mockito.any());
    }

    @Test
    public void testarCriacao() throws Exception {

        Mockito.when(produtoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        produtoService.create(criacaoDto());
        Mockito.verify(produtoRepository).save(Mockito.any());

    }
    @Test
    public void testarAlteracao() throws Exception {

        Mockito.when(produtoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        produtoService.update(criacaoDto());
        Mockito.verify(produtoRepository).save(Mockito.any());

    }
    private Produto criacao(){
        return  new Produto().builder()
                .id(1)
                .nome("teste")
                .valor(7.0)
                .descricao("teste")
                .categoria(Categorias.COMIDA)
                .imagem("teste")
                .build();
    }
    private ProdutoDto criacaoDto(){
        return  new ProdutoDto().builder()
                .id(1)
                .nome("teste")
                .valor(7.0)
                .descricao("teste")
                .categoria(CategoriaDto.COMIDA)
                .imagem("teste")
                .build();
    }
}
