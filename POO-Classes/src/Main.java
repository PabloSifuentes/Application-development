import Models.contaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        contaBancaria minhaConta = new contaBancaria("3399886", "Pablo", 0.00);
        minhaConta.getsaldo();


        //Depositar and Sacar

        int depositar = 1;
        int sacar = 2;
        int encerrar = 3;
        boolean controleDeSaque = true;

        while (true) {
            System.out.println("[1] Depósito\n[2] Sacar\n[3]Encerrar sessão");
            if (depositar == 1) {
                System.out.println("Insirá o valor:");
                Double dinheiroDeposito = entrada.nextDouble();
                saldo = saldo + dinheiroDeposito;
                controleDeSaque = false;
            }
            if (sacar == 2) {
                System.out.println("Insirá o valor;");
                Double dinheiroSaque = entrada.nextDouble();
                saldo = dinheiroSaque - saldo;
                controleDeSaque = false;
            }
            if (saldo < 0) {
                System.out.println("Erro, saldo insuficiente!");
                controleDeSaque = true;
            } else if ((!(depositar == 1)) && !(sacar == 2)) {
                System.out.println("opção inválida, tente novamente!");
                controleDeSaque = true;
            }
            if (encerrar == 3) {
                System.out.println("Sessão Encerrada.");
                break;
            }
        }
    }
}







