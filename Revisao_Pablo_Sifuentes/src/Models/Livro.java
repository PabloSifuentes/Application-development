package Models;

/**
 * Classe que representa um livro. Contendo ISBN, titulo, autor e ano de publicação
 *
 * */
public class Livro {


    private String isbn;

    private String titulo;

    private String autor;

    private int anoDePublicacao;


    /**
     * Construtor que instancia um objeto do tipo livro.
     * @param isbn Indentificador único do Livro.
     * @param titulo Titulo do Livro.
     * @param autor Autor do Livro.
     * @param anoDePublicacao Ano da publicação do Livro.
     */
//
    public Livro(String isbn, String titulo, String autor, int anoDePublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;

    }

    /**
     * Construtor sem argumentos do objeto Livro. Todos os atributos serão nulos.
     */
   public Livro(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    @Override
    public String toString() {
        return "Livro: O ISBN é " + isbn
                + "\nTitulo do Livro: " + titulo
                + "\nAutor do Livro: " + autor
                + "\nPublicação em: " + anoDePublicacao;
    }
}
