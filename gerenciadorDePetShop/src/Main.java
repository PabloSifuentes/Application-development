import Models.EntityPetshop;
import Models.GerenciadorPetshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        EntityPetshop entityCadastro = new EntityPetshop();
        GerenciadorPetshop gerenciar = new GerenciadorPetshop();

        while () {
            System.out.println("        -Cadastro de Cliente-");
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
                    System.out.println("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.println("CPF: ");
                    int cpf = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Pet: ");
                    String pet = entrada.nextLine();
                    System.out.println("Raça: ");
                    String raca = entrada.nextLine();

                    EntityPetshop clienteAdicionado = new EntityPetshop();
                    clienteAdicionado.setCliente(new String[]{nome});
                    clienteAdicionado.setCPF(new int[]{cpf});
                    clienteAdicionado.setAnimal(new String[]{raca});
                    clienteAdicionado.setTipoDeAnimal(new String[]{pet});

                    gerenciar.cadastrarClientes(clienteAdicionado);
                    break;

                case 2:
                    boolean controleServico = true;
                    while (controleServico) {
                        System.out.println("CPF do cliente: ");
                        int cpfCliente = entrada.nextInt();
                        if (entityCadastro.getCPF().equals(cpfCliente)) {
                            controleServico = true;
                        } else {
                            System.out.println("CPF não encontrado! tente novamente.");
                            controleServico = false;
                        }
                        System.out.println("Escolha o Serviço desejado: \n");
                        System.out.println("[1] - Banho [2] - Tosa");
                        int opcaoServico = entrada.nextInt();
                        if (opcaoServico == 1) {
                        }
                    }
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
}
