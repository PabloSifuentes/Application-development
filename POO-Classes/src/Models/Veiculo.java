package Models;

public abstract class Veiculo {

    //Atributos
    public String marca;

    public  String modelo;

    public  int ano;

//método abstrato

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public abstract void display();
}