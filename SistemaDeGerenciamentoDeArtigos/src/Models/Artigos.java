package Models;

public class Artigos {
    //Atributos

    private int id;

    private String titulo;

    private String autor;

    private int dataDePublicacao;

    //Construtor

    public Artigos(int id, String titulo, String autor, int dataDePublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataDePublicacao = dataDePublicacao;
    }

    //Métodos GET AND SET


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(int dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    //Método calcular idade do Artigo

    public int getIdadeArquivo() {
        int anoAtual = 2024;
        int idadeDosArtigos = anoAtual - dataDePublicacao;
        return idadeDosArtigos;
    }

    //Método toString()

    @Override
    public String toString() {
        return "Artigos{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataDePublicacao=" + dataDePublicacao +
                '}';
    }
}
