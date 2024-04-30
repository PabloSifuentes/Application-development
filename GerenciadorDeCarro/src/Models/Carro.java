package Models;

public class Carro {

    //Atributos

   private String placa;

   private String modelo;

   private String cor;

    int anoDeFabricacao;

    //construtor

    public Carro(String placa, String modelo, String cor, int anoDeFabricacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.anoDeFabricacao = anoDeFabricacao;
    }
    //Métodos


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public int getidade() {
        int anoAtual = 2024;
        int idade = anoAtual - anoDeFabricacao;
        return idade;
    }

    @Override
    public String toString() {
        return "Models.Carro{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", anoDeFabricacao=" + anoDeFabricacao +
                '}';
    }
}
