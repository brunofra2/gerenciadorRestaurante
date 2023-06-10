package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.*;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.PedidoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.PedidoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;
import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilsPedidoService.*;

@Service
public class PedidoServiceImpl implements PedidoService {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    public List<Pedido> findAll() {
        var usuarioLogado = usuarioRepository.findUsuario(captUsuarioLogado());
        if(usuarioLogado.getTypeUser() == TipoUsuario.GESTOR){
            return pedidoRepository.findAll();
        }else{
            return pedidoRepository.findUsuarioEmail(Utils.captUsuarioLogado());
        }


    }


    @Override
    public Pedido findById(Integer id) {
        var usuarioLogado = usuarioRepository.findUsuario(captUsuarioLogado());
        if(usuarioLogado.getTypeUser() == TipoUsuario.GESTOR){
            return trazerprodutosbyId(pedidoRepository.findById(id).get()
                    ,produtoPedidoRepository);
        }else{
            return trazerprodutosbyId(pedidoRepository.findUsuarioEmailByid(Utils.captUsuarioLogado(),id),produtoPedidoRepository);

        }
        }

    @Override
    public PedidoDto create(PedidoDto ped) {
        criarPedido(ped,produtoRepository,clienteRepository);
        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        return salvarManytoMany(entity,produtoPedidoRepository,
                ped,vo,produtoRepository,clienteRepository);
    }



    @Override
    public PedidoDto update(PedidoDto ped) {
        var pedido = pedidoRepository.findById(ped.getId()).get();
        if (ped == null) throw new RequiredObjectIsNullException();
        List<ProdutoDto> produtoList = new ArrayList<>();
        for (Produto p: pedido.getProdutoList()
             ) {
            produtoList.add(new ProdutoDto().builder().id(p.getId()).build());
        }
        ped.setTotal(pedido.getTotal());
        ped.setFkCliente(new ClienteDto().builder()
                .id(pedido.getId())
                .fkUsuario(
                        new UsuarioDto().builder()
                                .id(pedido.getFkCliente().getFkUsuario().getId()).build()
                ).build());
        ped.setProdutoDtolist(produtoList);
        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.delete(pedidoRepository.findById(id).get());
    }
}
