import Models.EntityPetshop;
import Models.GerenciadorPetshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

Scanner entrada = new Scanner(System.in);
        EntityPetshop entityCadastro = new EntityPetshop();
        GerenciadorPetshop gerenciar = new GerenciadorPetshop();

        System.out.println("" +
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑\n" +
                "┃ [1] - Cadastrar cliente            ┃\n" +
                "┃ [2] - Agendamento de Banho e Tosa  ┃\n" +
                "┃ [3] - Visualizar todos Cadastros   ┃\n" +
                "┃ [4] - Gerenciar Serviço            ┃\n" +
                "┃ [5] - Atualizar Cadastro           ┃\n" +
                "┃ [6] - Gerar Relatório              ┃\n" +
                "┃ [7] - Excluir Cadastro             ┃\n" +
                "┃ [8] - Encerrar                     ┃\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
int opcao = entrada.nextInt();
entrada.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Preencha com seus dados: \n");
                System.out.println("Nome: \n");
                String nome = entrada.nextLine();
                System.out.println("CPF: \n");
                int cpf = entrada.nextInt();
                System.out.println("Pet: \n");
                String pet = entrada.nextLine();
                System.out.println("Raça: \n");
                String raca = entrada.nextLine();

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:

        }

    }
}
