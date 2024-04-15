import Models.Calculadora;

public class Main {
    public static void main(String[] args) {

        int resultSoma = Calculadora.adicao(20,5);
        System.out.println("Valor da soma: "+resultSoma);

        int resultSubtracao = Calculadora.subtracao(200,100);
        System.out.println("Valor da subtração: "+resultSubtracao);

        int resultMultiplicacao = Calculadora.multiplicacao(3,5);
        System.out.println("Valor da multiplicação: "+resultMultiplicacao);

        int resultDivisao = Calculadora.divisao(10,2);
        System.out.println("Valor da divisão: "+resultDivisao);
    }
}