import Models.EntityPetshop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Models.GerenciadorPetshop gerenciar = new Models.GerenciadorPetshop();
        EntityPetshop clienteGlobal = new EntityPetshop();
        int tipoDeSevico12 = 0;
        int statusServico = 0;

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

                    boolean controleTipo = true;
                    while (controleTipo) {
                        System.out.println("Tipo de Serviço: \n [1]-Banho [2]-Tosa");
                        tipoDeSevico12 = entrada.nextInt();
                        if (tipoDeSevico12 != 1 && tipoDeSevico12 != 2) {
                            System.out.println("Opção invalida, tente novamente.");
                            controleTipo = true;
                        } else {
                            entrada.nextLine();
                            controleTipo = false;
                        }
                    }

                    boolean controleStatus = true;
                    while(controleStatus) {
                        System.out.println("Status do Serviço: \n [1]-Agendado [2]-Concluido");
                        statusServico = entrada.nextInt();
                        if (statusServico != 1 && statusServico != 2) {
                            System.out.println("Opção invalida, tente novamente.");
                            controleStatus = true;
                        } else {
                            entrada.nextLine();
                            controleStatus = false;
                        }
                    }

                    EntityPetshop cliente = new EntityPetshop(nome, pet, tipoDeAnimal, cpf, tipoDeSevico12, statusServico );
                    if (!gerenciar.adicionarCadastro(cliente)) {
                        System.out.println("Erro, Cliente já existente! tente novamente.");
                    }
                    break;
                case 2:
                    boolean controleServico = true;
                    while (controleServico) {
                        System.out.println("CPF do cliente: ");
                        int cpfCliente = entrada.nextInt();
                        entrada.nextLine();
                        EntityPetshop clienteEncontrado = gerenciar.buscarPorCPF(cpfCliente);

                        if (clienteEncontrado.getCPF() == cpfCliente) {
                            System.out.println("Cadastro encontrado.");
                            System.out.println(" Agendamento de " + clienteEncontrado.getCliente() + "\n[1]-Banho [2]-Tosa \nselecionado: " + clienteEncontrado.getTipoDeServico() + "\n[1]-Agendado [2]-Concluido \nselecionado: " + clienteEncontrado.getStatusDoServico());
                            controleServico = false;
                        } else {
                            System.out.println("Cadastro não encontrado.");
                            controleServico = true;
                        }
                    }
                case 3:
                    System.out.println("Visualização de todos Cadastros: \n ");
                    gerenciar.listarTodos();

                case 4:


                case 5:
                    System.out.println("Atualizar registro:\n");
                    boolean controleAtualizacao = true;

                    while (controleAtualizacao) {
                        System.out.println("Informe o CPF:\n");
                        int cpfCliente = entrada.nextInt();
                        EntityPetshop clinteEncontrado = gerenciar.buscarPorCPF(cpfCliente);
                        if (clinteEncontrado.getCPF() == cpfCliente) {
                            System.out.println("Registro encontrado!");
                            controleAtualizacao = false;
                            System.out.println("Novo Nome: \n");
                            String novoNome = entrada.nextLine();
                            System.out.println("Novo Animal: \n");
                            String novoAnimal = entrada.nextLine();
                            System.out.println("Novo tipo de animal: \n");
                            String novoTipoDeAnimal = entrada.nextLine();
                            gerenciar.atualizarCadastro(cpfCliente, novoNome, novoAnimal, novoTipoDeAnimal);
                        } else {
                            System.out.println("Registro não encontrado. Tente novamente.");
                            controleAtualizacao = true;
                        }
                    }
                case 6:
                case 7:
                case 8:
                    System.out.println("Encerrando.");
                    System.out.println("Encerrando..");
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    controleDoMenu = true;
            }
        }
        entrada.close();
    }
}
