import Models.GerenciadorDeCarro;
import Models.Carro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciadorDeCarro gerenciador = new GerenciadorDeCarro();

        while(true){
            System.out.println("Gerenciador de Carro:\n");
            System.out.println("[1]- Adicionar Carro\n[2]- Listar todos os carros\n[3]- Atualizar carro\n[4]- Remover carro\n[5]- Sair\n");
            System.out.println("Selecione uma opção: ");
            int entradaOpcao = entrada.nextInt();
            entrada.nextLine();

            switch (entradaOpcao) {
                case 1:
                    System.out.println("Insirá Placa: ");
                    String placa = entrada.nextLine();
                    System.out.println("Insirá Modelo: ");
                    String modelo = entrada.nextLine();
                    System.out.println("Insirá Cor: ");
                    String cor = entrada.nextLine();
                    System.out.println("Insirá Ano de fabricação: ");
                    int anoDeFabricacao = entrada.nextInt();
                    Carro novoCarro = new Carro(placa, modelo, cor, anoDeFabricacao);

                    if(!gerenciador.adicionarCarro(novoCarro)){
                        System.out.println("Erro: já existe esse Carro com essa placa.");
                    }
                    else {
                        System.out.println("Carro adicionado com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Lista de todos os carros:");
                    List<Carro> listaDeCarro = gerenciador.ObterTodosCarros();
                    listaDeCarro.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Atualizar o Carro: ");
                    System.out.println("Insirá a placa do carro para atualizar: ");
                    String placaParaAtualizar = entrada.nextLine();
                    System.out.println("Insirá o novo modelo: ");
                    String novoModelo = entrada.nextLine();
                    System.out.println("Insirá a nova cor: ");
                    String novaCor = entrada.nextLine();
                    gerenciador.atualizarCarro(placaParaAtualizar, novoModelo, novaCor);
                    System.out.println("Atualização Bem Sucedida!");
                    break;
                case 4:
                    System.out.println("Remover Carro: ");
                    System.out.println("Insirá a placa do carro a ser removido: ");
                    String placaParaRemover = entrada.nextLine();
                    gerenciador.romoverCarro(placaParaRemover);
                    System.out.println("Remoção Bem Sucedida!");
                    break;
                case 5:
                    System.out.println("Encerrando Programa...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente!");

            }
        }


    }

}