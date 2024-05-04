import java.util.List;
import java.util.Scanner;
import Models.Usuario;
import Models.GerenciadorUsuario;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();

        while (true) {
            System.out.println("\nGerenciador de Usuario\n");
            System.out.println("[1]-Adicionar Usuario\n[2]-Listar todos Usuários\n[3]-Encontrar ID do Usuario\n[4]-Atualizar Usuario\n[5]-Remover Usuario\n[6]-Finalizar");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Preencha as Informações solicitadas:");
                    System.out.println("ID:");
                    String id = entrada.nextLine();
                    System.out.println("Nome:");
                    String nome = entrada.nextLine();
                    System.out.println("Email:");
                    String email = entrada.nextLine();
                    Usuario novoUsuario = new Usuario(id, nome, email);

                    if (!gerenciador.adicionarUsuario(novoUsuario)) {
                        System.out.println("Erro, Usuario já existente! tente novamente.");
                    } else {
                        System.out.println("Usuario adicionado com Sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Lista de todos Usuarios:");
                    List<Usuario> listaUsuario = gerenciador.ObterTodosUsuarios();
                    listaUsuario.forEach(System.out::println);
            break;
            case 3:
                System.out.println("Insirá o ID do Usuário.");
                String procurarId = entrada.nextLine();
                System.out.println("Usuário encontrado!\n" + gerenciador.obterUsuarioPorId(procurarId));
                break;
            case 4:
                System.out.println("Insira o ID do usuário que deseja atualizar:");
                String idParaAtualizar = entrada.nextLine();
                System.out.println("Usuário encontrado!\n");
                System.out.println("Nome: ");
                String novoNome = entrada.nextLine();
                System.out.println("Email: ");
                String novoEmail = entrada.nextLine();
                gerenciador.atualizarUsuario(idParaAtualizar, novoNome, novoEmail);
                System.out.println("\nUsuário atualizado com sucesso!\n");
                break;
            case 5:
                System.out.println("Insirá o ID do usuário que será removido:");
                String removerUser = entrada.nextLine();
                gerenciador.removerUsuario(removerUser);
                System.out.println("Usuário removido!");
                break;
            case 6:
                System.out.println("Encerrando...");
                entrada.close();
                return; // Encerrar o programa
            default:
                System.out.println("opação inválida, tente novamente!");
                break;
            }
        }
    }
}


