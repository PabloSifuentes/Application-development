package Models;

public class Alunos {
    //Atributos

    private int matricula;

    private String nome;

    private String curso;

    private int anoDeIngresso;

    //Construtor

    public Alunos(int matricula, String nome, String curso, int anoDeIngresso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.anoDeIngresso = anoDeIngresso;
    }

    //Métodos Get and Set


    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoDeIngresso() {
        return anoDeIngresso;
    }
    public void setAnoDeIngresso(int anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }
    //Método calcular tempo de matricula

    public int getMatriculaDoAluno() {
        int anoAtual = 2024;
        int tempoDeMatricula = anoAtual - anoDeIngresso;
        return tempoDeMatricula;
    }

   //Método toString
    @Override
    public String toString() {
        return "Alunos{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", anoDeIngresso=" + anoDeIngresso +
                '}';
    }
}
