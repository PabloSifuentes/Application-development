import java.util.Scanner;

public class Main {
    public static <line> void main(String[] args) {
<<<<<<< HEAD

        Scanner entrada = new Scanner(System.in);

=======
        Scanner entrada = new Scanner(System.in);
>>>>>>> cbe47732225161d20499ade8247a459bbda7f3ad
        Usuario[] usuarios = new Usuario[100];
        int totalUsuarios = 0;
        boolean controleMenu = true;


        while (true) {
            System.out.println("\nGerenciador de Usuario\n");
            System.out.println("[1]-Adicionar Usuario\n[2]-Listar todos Usuários\n[3]-Encontrar ID do Usuario\n[4]-Atualizar Usuario\n[5]-Remover Usuario\n[6]-Finalizar");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Preencha as Informações solicitadas:");
                    System.out.println("ID:");
                    String id = entrada.next();
                    System.out.println("Nome:");
                    String nome = entrada.next();
                    System.out.println("Email:");
                    String email = entrada.next();

                    usuarios[totalUsuarios] = new Usuario(id, nome, email);
                    totalUsuarios++;

                    System.out.println("Usuário adicionado!\n" + id + "\n" + nome + "\n" + email + "\n");
                    break;
                case 2:
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
            }
        }
    }
}

