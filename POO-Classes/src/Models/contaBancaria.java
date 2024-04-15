package Models;

public class contaBancaria {

    //Atributos adicionados.
    private String numeroDaConta;

    private String nomeDoTitular;

    private Double saldo;

    //Contrutor da conta.
    public contaBancaria (String numeroDaConta, String nomeDoTitular, Double saldo){
        this.numeroDaConta = numeroDaConta;
        this.nomeDoTitular = nomeDoTitular;
        this.saldo = saldo;
    }

    //GET and SET.
    public String getnumeroDaConta() {
        return numeroDaConta;
    }
    public void setnumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getnomeDoTitular() {
        return nomeDoTitular;
    }
    public void setnomeDotitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public Double getsaldo() {
        return saldo;
    }
    public void setsaldo() {
        this.saldo = saldo;
    }

    //Extrato
    public void imprimirExtrato() {
        System.out.println("Titular:"+nomeDoTitular+" Conta:"+numeroDaConta+" Saldo:"+saldo);
    }


}
