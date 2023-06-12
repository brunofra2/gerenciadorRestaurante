package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.UtilsTest.Constantes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.SituacoesDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.Situacoes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.PedidoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.PedidoServiceImpl;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
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
@DisplayName("Teste do service - Endereço Service")
public class PedidoServiceImplTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoServiceImpl pedidoService;

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosPedidoPorUsuario() throws Exception{
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Pedido> pedidos = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(pedidoRepository.findUsuarioEmail(Utils.captUsuarioLogado(),pageRequest))
                .thenReturn(pedidos);
        pedidoService.findAll(page,pageSize);
        Mockito.verify(pedidoRepository).findUsuarioEmail(Utils.captUsuarioLogado(),pageRequest);
    }

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosPedidosTodos() {
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Pedido> pedidos = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(pedidoRepository.buscarTodos(pageRequest))
                .thenReturn(pedidos);
        pedidoService.findAll(page,pageSize);
        Mockito.verify(pedidoRepository).buscarTodos(pageRequest);
    }

    @Test
    public void deveListarosPedidosTodosFinalizados() {
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Pedido> pedidos = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(pedidoRepository.findAllfinaly(pageRequest))
                .thenReturn(pedidos);
        pedidoService.findFinally(page,pageSize);
        Mockito.verify(pedidoRepository).findAllfinaly(pageRequest);
    }

    @Test
    public void deveListarosPedidosTodosFinalizadosPorCliente() {
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Pedido> pedidos = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(pedidoRepository.findfinaly(Mockito.any(),pageRequest))
                .thenReturn(pedidos);
        pedidoService.findFinally(page,pageSize);
        Mockito.verify(pedidoRepository).findfinaly(Mockito.any(),pageRequest);
    }

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosPedidoPorId() throws MyRunTimeException {
        Mockito.when(pedidoRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(criacao()));
        pedidoService.findById(Mockito.any());
        Mockito.verify(pedidoRepository).findById(Mockito.any());
    }

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosPedidoPorIdUsuario() throws MyRunTimeException {
        Mockito.when(pedidoRepository.findUsuarioEmailByid(Mockito.any(),Mockito.any()))
                .thenReturn(criacao());
        pedidoService.findById(Mockito.any());
        Mockito.verify(pedidoRepository).findUsuarioEmailByid(Mockito.any(),Mockito.any());
    }

    @Test
    public void testarCriacao() throws Exception {

        Mockito.when(pedidoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        pedidoService.create(criacaoDto());
        Mockito.verify(pedidoRepository).save(Mockito.any());

    }

    @Test
    public void testarAlteracao() throws Exception {

        Mockito.when(pedidoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        pedidoService.update(criacaoDto());
        Mockito.verify(pedidoRepository).save(Mockito.any());

    }
    private Pedido criacao(){
        List< Produto > list = List.of(new Produto().builder()
                        .id(1)
                .build());
        return  new Pedido().builder()
                .id(1)
                .total(7.0)
                .status(Situacoes.CADASTRADO)
                .produtoList(list)
                .fkCliente(new Cliente().builder()
                        .id(2)
                        .build())
                .build();
    }

    private PedidoDto criacaoDto(){
        List<ProdutoDto> list = List.of(new ProdutoDto().builder()
                .id(1)
                .build());
        return  new PedidoDto().builder()
                .id(1)
                .total(7.0)
                .status(SituacoesDto.CADASTRADO)
                .produtoDtolist(list)
                .fkCliente(new ClienteDto().builder()
                        .id(2)
                        .build())
                .build();
    }



}
