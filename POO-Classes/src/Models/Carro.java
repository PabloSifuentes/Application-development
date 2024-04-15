package Models;

public class Carro extends Veiculo {

    //Atributo
    private int numeroDePortas;

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        super(marca, modelo, ano);
        this.numeroDePortas = numeroDePortas;
    }
    public void display() {
        System.out.println("\n Marca: "+marca+"\n Modelo: "+modelo+"\n ano: "+ano+"\n Numero de portas: "+numeroDePortas);
    }
}