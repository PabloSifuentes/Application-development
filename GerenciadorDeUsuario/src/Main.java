import java.util.List;
import java.util.Scanner;
import Models.Usuario;
import Models.GerenciadorUsuario;

public class Main {
<<<<<<< HEAD
    public static <line> void main(String[] args) {
<<<<<<< HEAD

        Scanner entrada = new Scanner(System.in);

=======
        Scanner entrada = new Scanner(System.in);
>>>>>>> cbe47732225161d20499ade8247a459bbda7f3ad
        Usuario[] usuarios = new Usuario[100];
        int totalUsuarios = 0;
        boolean controleMenu = true;

=======
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
>>>>>>> 231764e48891082b0c638c95d670be9d6ac48048

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
<<<<<<< HEAD
                    System.out.println("Todos Usuários!");
                    for (int i = 0; i < totalUsuarios; i++) {
                        assert usuarios[i] != null;
                        System.out.println("ID: " + usuarios[i].getId());
                        System.out.println("Nome: " + usuarios[i].getNome());
                        System.out.println("Email: " + usuarios[i].getEmail());
                    }
                    break;
                case 3:
                    System.out.println("Insirá o ID do Usuário.");
                    String procurarId = entrada.next();
                    boolean encontrado = false;

                    for (int i = 0; i < totalUsuarios; i++) {
                        assert usuarios[i] != null;
                        if (usuarios[i].getId().equals(procurarId)) {
                            System.out.println("Usuário encontrado!");
                            System.out.println("ID: " + usuarios[i].getId());
                            System.out.println("Nome: " + usuarios[i].getNome());
                            System.out.println("Email: " + usuarios[i].getEmail());

                        } else {
                            System.out.println("Nenhum usuário encontrado!");
                        }
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Insira o ID do usuário que deseja atualizar:");
                    String idAtualizar = entrada.next();
                    encontrado = false;

                    for (int i = 0; i < totalUsuarios; i++) {
                        assert usuarios[i] != null;
                        if (usuarios[i].getId().equals(idAtualizar)) {
                            encontrado = true;
                            System.out.println("Usuário encontrado!\n");
                            System.out.println("ID: " + usuarios[i].getId());
                            System.out.println("Nome: " + usuarios[i].getNome());
                            System.out.println("Email: " + usuarios[i].getEmail());

                            // Solicitar novos dados do usuário
                            System.out.println("\nAtualize os dados do usuário:");
                            System.out.print("Novo ID: ");
                            String novoId = entrada.next();
                            System.out.print("Novo Nome: ");
                            String novoNome = entrada.next();
                            System.out.print("Novo Email: ");
                            String novoEmail = entrada.next();

                            // Atualizar o usuário no array
                            usuarios[i].setId(novoId);
                            usuarios[i].setNome(novoNome);
                            usuarios[i].setEmail(novoEmail);

                            System.out.println("\nUsuário atualizado com sucesso!\n");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Usuário não encontrado!\n");
                    }
                    break;
                case 5:
                    System.out.println("Insirá o ID do usuário que será removido:");
                    String removerUser = entrada.next();
                    encontrado = false;

                    for (int i = 0; i < totalUsuarios; i++) {
                        assert usuarios[i] != null;
                        if (usuarios[i].getId().equals(removerUser)) {
                            System.out.println("Usuário encontrado!");
                            System.out.println("ID: " + usuarios[i].getId());
                            System.out.println("Nome: " + usuarios[i].getNome());
                            System.out.println("Email: " + usuarios[i].getEmail());
                            System.out.println("Usuário removido!");
                            usuarios[i] = null;
                            totalUsuarios--;
                            break;
                        } else {
                            System.out.println("Nenhum usuário encontrado!");
                        }
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    entrada.close();
                    return; // Encerrar o programa

                default:
                    System.out.println("opação inválida.");
                    break;
=======
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
>>>>>>> 231764e48891082b0c638c95d670be9d6ac48048
            }
        }
    }
}


