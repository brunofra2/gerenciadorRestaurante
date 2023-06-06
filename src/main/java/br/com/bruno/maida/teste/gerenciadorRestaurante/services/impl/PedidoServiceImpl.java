package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.ProdutoPedido;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.ProdutoPedidoRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.PedidoService;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.PedidoRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    @Override
    public List<Pedido> findAll() {

        return trazerprodutos(pedidoRepository.findAll());
    }

    private List<Pedido> trazerprodutos(List<Pedido> pedidos){
        List<Pedido> pedidoListComProdutos = new ArrayList<>();
        List<Produto> produtoList = new ArrayList<>();

        for (Pedido pe: pedidos
             ) {
            for (Integer i: produtoPedidoRepository.findByIdPedido(pe.getId())
            ) {
                produtoList.add(new Produto().builder()
                        .id(i)
                        .build());
            }
           pedidoListComProdutos.add( new Pedido().builder()
                   .id(pe.getId())
                   .total(pe.getTotal())
                   .status(pe.getStatus())
                   .fkCliente(pe.getFkCliente())
                   .produtoList( produtoList)
                   .build());
        }
        return pedidoListComProdutos;
    }

    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id).get();
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
