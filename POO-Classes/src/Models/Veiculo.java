package Models;


//Classe abstrata que representa um veiculo genérica
public abstract class Veiculo {

    //Atributos
    protected String marca;

    protected   String modelo;

    protected   int ano;

/*construtor para inicializar os atributos de veiculos.
    @param marca A Marca do veiculo.
    @param modelo O Modelo do veiculo.
    @param ano O Ano do veiculo.
*/
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    public abstract void display();
}