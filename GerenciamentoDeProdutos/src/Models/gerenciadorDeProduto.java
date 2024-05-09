package Models;

import java.util.ArrayList;
import java.util.List;

public class gerenciadorDeProduto {
    List<Produto> listaDeProdutos = new ArrayList<>();

    //Métodos CRUD

    public boolean adicionarProduto(Produto produtoAdicionado) {
        for(Produto produtoDentroDaLista : listaDeProdutos) {
            if(produtoDentroDaLista.getCodigo() == produtoAdicionado.getCodigo()) {
                return false;
            }
        }
        listaDeProdutos.add(produtoAdicionado);
        return true;
    }
    public List<Produto> listarProdutos() {
    return listaDeProdutos;
    }

    public Produto obterProdutoPorCodigo(int codigoDeBusca) {
        for(Produto produtoDentroDaLista : listaDeProdutos) {
            if(produtoDentroDaLista.getCodigo() == codigoDeBusca) {
                return produtoDentroDaLista;
            }
        }
        return null;
    }
    public void atualizarProduto(int codigoDeBusca, String novoNome, String novaCategoria, double novoPreco ) {
        Produto produtoParaAtualizar = obterProdutoPorCodigo(codigoDeBusca);
        if(produtoParaAtualizar != null){
            produtoParaAtualizar.setNome(novoNome);
            produtoParaAtualizar.setCategoria(novaCategoria);
            produtoParaAtualizar.setPreco(novoPreco);
        }
    }
    public void reomoverProduto(int codigoParaBusca) {
        listarProdutos().removeIf(produto -> produto.getCodigo() == codigoParaBusca);
    }



}
