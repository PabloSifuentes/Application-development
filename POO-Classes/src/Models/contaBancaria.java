//package Models;
//
//import java.util.Scanner;
//
//public class contaBancaria {
//scanner entrada = new Scanner(Sistem.in);
//   private String numeroDaConta;
//
//   private String nomeDoTitular;
//
//   private Double saldo = 0.00;
//
//   public String getNumeroDaConta() {
//       return numeroDaConta;
//   }
//   public void setNumeroDaConta(String numeroDaConta) {
//       this.numeroDaConta = numeroDaConta;
//   }
//
//   public String getNomeDoTitular() {
//       return nomeDoTitular;
//   }
//   public void setNomeDoTitular(String nomeDoTitular) {
//       this.nomeDoTitular = nomeDoTitular;
//   }
//
//   public Double getSaldo() {
//       return
//   }
//
//
//
//
//
//    //métodos
//    public void numeroDaConta () {
//        System.out.println(numeroDaConta);
//    }
//    public void numeroDoTitular () {
//        System.out.println(nomeDoTitular);
//    }
//    public void depositar () {
//        int depositar = 1;
//        int sacar = 2;
//        Boolean controleDeSaque = true;
//
//        while(true){
//        System.out.println("[1] Depositar \n[2] Sacar");
//        if(depositar == 1) {
//            System.out.println("Insira o valor:");
//            Double dinheiroDeposito = entrada.next();
//            saldo = saldo + dinheiroDeposito;
//            controleDeSaque = false;
//
//        }
//        if(sacar == 2) {
//            System.out.println("Insira o valor:");
//            Double dinheiroSaque = entrada.next();
//            saldo = dinheiroSaque - saldo;
//            if(saldo < 0) {
//                System.out.println("Erro, saldo insuficiente!");
//            }
//            }
//            controleDeSaque = false;
//
//
//        }
//        if(!(depositar==1) && !(sacar==2)) {
//                System.out.println("opção invalida, tente novamente!");
//                controleDeSaque = true;
//        }
//
//        }
//        }
//        }
//
//
//
