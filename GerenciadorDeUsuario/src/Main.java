import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);

        Usuario user01 = new Usuario("15", "teste", "teste@test.com");
        GerenciadorUsuario ger01 = new GerenciadorUsuario();


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
                System.out.println("Usuário adicionado!");
                 break;
             case 2:
                 System.out.println("Todos Usuários!");
                 break;
             case 3:
                 System.out.println("ID Usuários!");
                 break;
             case 4:
                 System.out.println("Usuário atualizado!");
                 break;
             case 5:
                 System.out.println("Usuário removido!");
                 break;
             case 6:
                 System.out.println("Encerrado!");
                break;
        }





    }
}