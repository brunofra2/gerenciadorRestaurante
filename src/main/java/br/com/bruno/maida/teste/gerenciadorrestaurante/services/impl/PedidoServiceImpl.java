package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.ProdutoPedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoPedidoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.PedidoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.PedidoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.PedidoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilServices.*;

@Service
public class PedidoServiceImpl implements PedidoService {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;


    @Override
    public List<Pedido> findAll() {
        return trazerprodutos(pedidoRepository.findUsuarioEmail(captUsuarioLogado())
                ,produtoPedidoRepository);
    }


    @Override
    public Pedido findById(Integer id) {
        return trazerprodutosbyId(pedidoRepository.findUsuarioEmailByid(captUsuarioLogado(),id),produtoPedidoRepository);
    }

    @Override
    public PedidoDto create(PedidoDto ped) {
        if (ped == null) throw new RequiredObjectIsNullException();

        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        salvarManytoMany(entity);
        return vo;
    }

    private void salvarManytoMany(Pedido ped){
        for (Produto pro : ped.getProdutoList()
             ) {
            produtoPedidoRepository.save(new ProdutoPedido().builder()
                    .idProduto(pro)
                    .idPedido(ped)
                    .build());
        }
    }

    @Override
    public PedidoDto update(PedidoDto ped) {
        if (ped == null) throw new RequiredObjectIsNullException();

        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.delete(pedidoRepository.findById(id).get());
    }
}
