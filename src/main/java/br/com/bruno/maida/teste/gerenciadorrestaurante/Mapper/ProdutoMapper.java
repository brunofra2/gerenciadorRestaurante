package br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.CategoriaDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.Categorias;

public class ProdutoMapper {


    public static ProdutoDto convertModelToDto(Produto origin){


        return  new ProdutoDto().builder()
                .id(origin.getId())
                .descricao(origin.getDescricao())
                .nome(origin.getNome())
                .valor(origin.getValor())
                .imagem(origin.getImagem())
                .categoria(CategoriaDto.valueOf(origin.getCategoria().toString()))
                .build();
    }

    public static  Produto convertDtoToModel(ProdutoDto origin){
       return new Produto().builder()
                .id(origin.getId())
                .descricao(origin.getDescricao())
                .nome(origin.getNome())
                .valor(origin.getValor())
                .imagem(origin.getImagem())
                .categoria(Categorias.valueOf(origin.getCategoria().toString()))
                .build();
    }
}

