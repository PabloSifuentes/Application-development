package Models;

public class Livro {
    //Atributos

    private String titulo;

    private String autor;

    private int anoDePublicacao;

    private Boolean estaEmprestado = false;

    //Construtor

    public Livro(String titulo, String autor, int anoDePublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.estaEmprestado = false;
    }

    //Métodos

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

    //Método Emprestar and Devolver

    public void emprestar() {
        if (estaEmprestado) {
            estaEmprestado = true;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Este Livro já foi emprestado.");
        }
    }
    public void devolver() {
        if (estaEmprestado) {
            estaEmprestado = false;
            System.out.println("Livro devolvido com Sucesso!");
        } else {
            System.out.println("Este Livro já está disponível.");
        }
    }


    //Método imprimir
    public void imprimirInformacoes() {
        System.out.println("Referencia do livro:\n Título: " + titulo + "\n Autor: " + autor + "\n Ano de Publicação: " + anoDePublicacao + "\n Emprestado: " + estaEmprestado);
    }
}