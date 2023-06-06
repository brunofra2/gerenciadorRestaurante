package br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;

public class ProdutoMapper {


    public static ProdutoDto convertModelToDto(Produto origin){


        return  new ProdutoDto().builder()
                .id(origin.getId())
                .descricao(origin.getDescricao())
                .nome(origin.getNome())
                .valor(origin.getValor())
                .imagem(origin.getImagem())
                .build();
    }

    public static  Produto convertDtoToModel(ProdutoDto origin){
       return new Produto().builder()
                .id(origin.getId())
                .descricao(origin.getDescricao())
                .nome(origin.getNome())
                .valor(origin.getValor())
                .imagem(origin.getImagem())
                .build();
    }
}

