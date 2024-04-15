import Models.Livro;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            Livro meuLivro = new Livro("Star Wars", "George Lucas", 1977);

            meuLivro.imprimirInformacoes();




        }
    }
}