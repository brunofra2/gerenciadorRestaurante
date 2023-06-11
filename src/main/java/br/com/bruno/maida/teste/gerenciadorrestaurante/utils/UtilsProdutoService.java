package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

public class UtilsProdutoService {

    public static void verificarCampos(ProdutoDto produtoDto) throws MyRunTimeException {

        if(produtoDto.getNome() == null
        || produtoDto.getValor() == null
        || produtoDto.getDescricao() == null
        || produtoDto.getImagem() == null
        || produtoDto.getCategoria().toString() == null){
            throw  new MyRunTimeException("verifique se todos os campos estão preenchidos");
        }

    }
}
