package Models;

import java.util.ArrayList;
import java.util.List;

public class gerenciadorDeLivros {
    List<Livros>listaDeLivros = new ArrayList<>();

    //Métodos

    public boolean adicionarLivro(Livros livroInformado){
        for(Livros livroDentroDaLista : listaDeLivros) {
            if (livroDentroDaLista.getISBN().equals(livroInformado.getISBN())) {
            return false;
            }
        }
        listaDeLivros.add(livroInformado);
        return true;
    }

    public List<Livros>obterLivrosCadastrados() {
    return listaDeLivros;
    }

    public Livros obterLivroPorISBN(String ISBNParaBusca) {
        for(Livros livroDentroDaLista : listaDeLivros) {
            if(livroDentroDaLista.getISBN().equals(ISBNParaBusca)) {
                return livroDentroDaLista;
            }
        }
        return null;
    }

    public void atualizarLivroCompleto(String ISBNParaAtualizar, String novoTitulo, String novoAutor) {
        Livros livroParaAtualizar = obterLivroPorISBN(ISBNParaAtualizar);
            if(livroParaAtualizar != null) {
                livroParaAtualizar.setTitulo(novoTitulo);
                livroParaAtualizar.setAutor(novoAutor);
            }
        }
        public void atualizarLivroTitulo(String ISBNParaAtualizar, String novoTitulo) {
            Livros livroParaAtualizar = obterLivroPorISBN(ISBNParaAtualizar);
                if(livroParaAtualizar != null){
                livroParaAtualizar.setTitulo(novoTitulo);
                }
            }
        public void atualizarLivroAutor(String ISBNParaAtualizar, String novoAutor) {
        Livros livroParaAtualizar = obterLivroPorISBN(ISBNParaAtualizar);
        if(livroParaAtualizar != null) {
            livroParaAtualizar.setAutor(novoAutor);
            }
        }

        public void removerLivro(String livroRemover) {
        listaDeLivros.removeIf(livros -> livros.getISBN().equals(livroRemover));
        }




}
