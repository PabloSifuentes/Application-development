package Models;

public class Calculadora {

    public static int adicao(int num1, int num2) {
        return num1 + num2;
    }
    public static int subtracao(int num3, int num4) {
        return num3 - num4;
    }

    public static int multiplicacao(int num5, int num6) {
        return num5 * num6;
    }

    public static int divisao(int num7, int num8) {
        if(num8 == 0) {
            System.out.println("Não é possivel dividir por 0!");
        }
        return num7 / num8;
    }
}


