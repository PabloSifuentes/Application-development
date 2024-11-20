import Models.EntityPetshop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Models.GerenciadorPetshop gerenciar = new Models.GerenciadorPetshop();
        int tipoDeSevico12 = 0;
        int statusServico = 0;

        boolean controleDoMenu = true;
        while (controleDoMenu) {
            System.out.println("        -Cadastro de Cliente-");
            System.out.println("" +
                    "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑\n" +
                    "┃ [1] - Cadastrar cliente            ┃\n" +
                    "┃ [2] - Visualizar todos Cadastros   ┃\n" +
                    "┃ [3] - Gerenciar Serviço            ┃\n" +
                    "┃ [4] - Atualizar Cadastro           ┃\n" +
                    "┃ [5] - Gerar Relatório              ┃\n" +
                    "┃ [6] - Excluir Cadastro             ┃\n" +
                    "┃ [7] - Encerrar                     ┃\n" +
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
                    while (controleStatus) {
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
                    EntityPetshop cliente = new EntityPetshop(nome, pet, tipoDeAnimal, cpf, tipoDeSevico12, statusServico);
                    if (!gerenciar.adicionarCadastro(cliente)) {
                        System.out.println("Erro, Cliente já existente! tente novamente.");
                    }
                    break;
                case 2:
                    System.out.println("Visualização de todos Cadastros: \n ");

                    if (gerenciar.listarTodos()) { // Supondo que o método listarTodos() retorne a lista de clientes
                        continue;
                    }
                        System.out.println("Nenhum cliente cadastrado até o momento. Retornando ao menu principal...");
                    break;
                case 3:
                    System.out.println("CPF do Cliente:");
                    int cpfCliente = entrada.nextInt();
                    entrada.nextLine();
                    EntityPetshop clienteEncontrado = gerenciar.buscarPorCPF(cpfCliente);

                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado: " + clienteEncontrado.getCliente());
                        System.out.println("Agendamento atual: " + (clienteEncontrado.getTipoDeServico() == 1 ? "Banho" : "Tosa"));
                        System.out.println("Status atual: " + (clienteEncontrado.getStatusDoServico() == 2 ? "Agendado" : "Concluído"));
                        System.out.println("\n");
                        System.out.println("Escolha o tipo de Serviço: [1] Banho [2] Tosa");
                        int novoServico = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Escolha o status: [1] Agendamento [2] Concluido");
                        int novoStatus = entrada.nextInt();
                        entrada.nextLine();

                        gerenciar.agendamento(cpfCliente, novoServico, novoStatus);
                    } else {
                        System.out.println("Tente novamente.");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("Atualizar registro:\n");
                    System.out.println("Informe o CPF:\n");
                    cpfCliente = entrada.nextInt();
                    entrada.nextLine();

                    EntityPetshop clinteEncontrado = gerenciar.buscarPorCPF(cpfCliente);
                    if (clinteEncontrado != null) {
                        System.out.println("Registro encontrado!");
                        System.out.println("Novo Nome: \n");
                        String novoNome = entrada.nextLine();
                        System.out.println("Novo Animal: \n");
                        String novoAnimal = entrada.nextLine();
                        System.out.println("Novo tipo de animal: \n");
                        String novoTipoDeAnimal = entrada.nextLine();
                        gerenciar.atualizarCadastro(cpfCliente, novoNome, novoAnimal, novoTipoDeAnimal);
                    } else {
                        System.out.println("Tente novamente.");
                        continue;
                    }
                    break;
                case 5:
                    System.out.println("       - Relatório Geral -");
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");

                    int totalClientes = 0;
                    int totalBanhos = 0;
                    int totalTosas = 0;
                    int totalAgendados = 0;
                    int totalConcluidos = 0;

                    // calcular as estatísticas
                    for (EntityPetshop cadastro : gerenciar.getListaDeCadastro()) {
                        totalClientes++;


                        if (cadastro.getTipoDeServico() == 1) {
                            totalBanhos++;
                        } else if (cadastro.getTipoDeServico() == 2) {
                            totalTosas++;
                        }


                        if (cadastro.getStatusDoServico() == 1) {
                            totalAgendados++;
                        } else if (cadastro.getStatusDoServico() == 2) {
                            totalConcluidos++;
                        }
                    }

                    // Exibir resultados
                    System.out.println("Total de clientes cadastrados: " + totalClientes);
                    System.out.println("Serviços agendados:");
                    System.out.println(" - Banho: " + totalBanhos);
                    System.out.println(" - Tosa: " + totalTosas);
                    System.out.println("Status dos serviços:");
                    System.out.println(" - Agendados: " + totalAgendados);
                    System.out.println(" - Concluídos: " + totalConcluidos);
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
                continue;
                case 6:
                    System.out.println("Insirá o CPF a ser Removido: ");
                    int removerCliente = entrada.nextInt();
                    entrada.nextLine();

                    EntityPetshop clienteRemover = gerenciar.buscarPorCPF(removerCliente);
                    if (clienteRemover != null){
                    gerenciar.removerCadastro(removerCliente);
                        System.out.println("Cadastro removido com sucesso!");
                    } else {
                        System.out.println("Tente novamente.");
                        continue;
                    }
                    break;
                case 7:
                    System.out.println("Encerrando.");
                    System.out.println("Encerrando..");
                    System.out.println("Encerrando...");
                    controleDoMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
            entrada.close();
    }
}
