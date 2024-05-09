package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar os Livros. Possui uma lista de livros e implementa os métodos
 * CRUD (create, read, Update e Delete) para a lista.
 */
public class gerenciadorDeLivro {
    private List<Livro> listaDeLivros = new ArrayList<>();

    /**
     * Construtor da classe Gerenciador de livros. A lista já foi inicializada
     * dentro da classe, não é necessário passaar por parâmetro.
     */
    public gerenciadorDeLivro() {
    }

    /**
     * Método responsável por adicionar um livro à lista de Livros.
     * É usadoo métod.add da Classe ArrayList para adicionar.
     * Não pode ser adicionado um Livro com ISBN igual à um existente na lista.
     * Para isso a lista é interada e o ISB do livro dentro d lista é comparado com o ISBN do
     * livroAdicionado. Será utilizando o método.equals da classe String para fazer a comparação.
     *
     * @param livroAdicionado Objeto do tipo Livro que será adicionado.
     */
    public void adicionarLivro(Livro livroAdicionado) {
        for (Livro livroDentroDalista : listaDeLivros) {
            if (livroDentroDalista.equals(livroAdicionado.getIsbn())) {
                System.out.println("Erro: Livro já cadastrado!");
            } else {
                System.out.println("Livro adicionado com sucesso!");
                listaDeLivros.add(livroAdicionado);
            }
        }
    }

    /**
     * Retornar todos os livros dentro da lista de livros.
     *
     * @return listaDeLivros a ser retornada.
     */
    public void obterTodosLivrosCadastrados() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Não há livros na lista!");
        }
        listaDeLivros.forEach(System.out::println);
    }

    /**
     * Método responsável por retornar um livro. A lista de livros é iterada e o método.equals
     * da classe String é utilizado para comparar o ISBN fornecido com o.getISBN de cada livro
     * dentro da lista. Se não houver livro com o ISBN correspondente, retorna null. Deve ser tratado
     * onde for usado.
     * @param isbnBusca ISBN que está sendo buscado
     * @return Livro que tem o ISBN igual ao buscado.
     */
    private Livro obterLivroPorISBN(String isbnBusca) {
        for (Livro livroDentroDaLista : listaDeLivros) {
            if (livroDentroDaLista.getIsbn().equals(isbnBusca)) {
                return livroDentroDaLista;
            } else {
                System.out.println("Livro não encontrado!");
            }
        }
        return null;
    }

    /**
     * Método responsável por atualizar todos parâmetros de um livro.
     * Utiliza
     * @param isbnBusca
     * @param novoTitulo
     * @param novoAutor
     * @param novoAnoDePublicacao
     */
        public void atualizarLivro (String isbnBusca, String novoTitulo , String novoAutor, int novoAnoDePublicacao){
            Livro livroDentroDalista = obterLivroPorISBN(isbnBusca);
            if (livroDentroDalista != null) {
                livroDentroDalista.setTitulo(novoTitulo);
                livroDentroDalista.setAutor(novoAutor);
                livroDentroDalista.setAnoDePublicacao(novoAnoDePublicacao);
                System.out.println("Livro atualizado com sucesso!");
                System.out.println(livroDentroDalista);
            }
            else {
                System.out.println("Livro não foi cadastrado!");
            }
        }
        public void atualizarLivroTitulo(String isbnBusca, String novoTitulo) {
            Livro livroDentroDaLista = obterLivroPorISBN(isbnBusca);
                if(livroDentroDaLista != null) {
                    livroDentroDaLista.setTitulo(novoTitulo);
                }
                else {
                    System.out.println("Livro não cadastrado!");
                }
            }
        public void atualizarLivroAutor(String isbnBusca, String novoAutor) {
            Livro livroDentroDaLista = obterLivroPorISBN(isbnBusca);
                if(livroDentroDaLista != null) {
                    livroDentroDaLista.setAutor(novoAutor);
                }
                else {
                    System.out.println("Livro não Cadastrado!");
                }
            }
            public void atualizarLivroAnoDePublicacao(String isbnBusca, int novAnoDePublicacao) {
            Livro livroDentroDaLista = obterLivroPorISBN(isbnBusca);
                if(livroDentroDaLista != null) {
                    livroDentroDaLista.setAnoDePublicacao(novAnoDePublicacao);
                }
                }

    /**
     * Método responsável por remover Livro da lista. É utilizado um predicado (lambda), e o método.removeIf(), para comparar
     * o ISBN informado com todos os livros da lista e remover se encontrado.
     * Caso não seja encontrado, uma mensagem é exibida para usuário.
     * @param isbnRemover identificador para ser utilizado o método de livroRemover .
     */
    public void livroRemover (String isbnRemover){
         boolean removido = listaDeLivros.removeIf(livro -> livro.getIsbn().equals(isbnRemover));
         if(removido){
             System.out.println("Livro removido com sucesso!");
         }
         else {
             System.out.println("livro com ISBN: " + isbnRemover + " não encontrado!");
         }
        }
    }

