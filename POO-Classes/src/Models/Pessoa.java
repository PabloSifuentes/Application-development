package Models;

public class Pessoa {

    //Atributos
    private String nome;

    private int idade;

    private double altura;

    //Construtor
    public Pessoa(String nome, int idade, double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    //Métodos
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getAltura () {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }


    public void falar() {
        System.out.println("Olá, meu nome é " + nome + " e eu tenho " + idade + " anos.");
    }
 }

