package Models;

public class Livros {

    //Atributos

    private String ISBN;

    private String titulo;

    private String autor;

    private int anoDePublicacao;

    //contrutor

    public Livros (String ISBN,String titulo,String autor,int anoDePublicacao ){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }
    //Métodos GET AND SET

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    //Método toString()

    @Override
    public String toString() {
        return "Livros{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoDePublicacao=" + anoDePublicacao +
                '}';
    }
}
