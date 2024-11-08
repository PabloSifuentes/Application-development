import Models.EntityPetshop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Models.GerenciadorPetshop gerenciar = new Models.GerenciadorPetshop();
        EntityPetshop clienteGlobal = new EntityPetshop();

        boolean controleDoMenu = true;
        while (controleDoMenu) {
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
                    String tipoDeAnimal = entrada.nextLine();
                    System.out.println("Tipo de Serviço: \n [1]-Banho [2]-Tosa");
                    int tipoDeSevico12 = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Status do Serviço: \n [1]-Agendado [2]-Concluido");
                    int statusServiço = entrada.nextInt();
                    entrada.nextLine();

                    EntityPetshop cliente = new EntityPetshop(nome, pet, tipoDeAnimal, cpf, tipoDeSevico12, statusServiço );
                    if (!gerenciar.adicionarCadastro(cliente)) {
                        System.out.println("Erro, Cliente já existente! tente novamente.");
                    }
                    break;
                case 2:
                    boolean controleServico = true;
                    while (controleServico) {
                        System.out.println("CPF do cliente: ");
                        int cpfCliente = entrada.nextInt();
                        EntityPetshop clienteEncontrado = gerenciar.buscarPorCPF(cpfCliente);

                        if (clienteEncontrado.getCPF() == cpfCliente) {
                            System.out.println("Cadastro encontrado.");
                            System.out.println(clienteGlobal.getCliente()+ " Agendamento: \n" + clienteGlobal.getTipoDeServico() + clienteGlobal.getStatusDoServico());

                        } else {
                            System.out.println("Cadastro não encontrado.");
                            controleServico = false;
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

    private static class GerenciadorPetshop {
    }
}
