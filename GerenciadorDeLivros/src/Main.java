import Models.Livros;
import Models.gerenciadorDeLivros;

import java.util.List;
import java.util.Scanner;

public class Main {

     public static void main(String[] args){
     Scanner entradaLivro = new Scanner(System.in);
     gerenciadorDeLivros meuGerenciador = new gerenciadorDeLivros();

    while (true) {
        System.out.println("Gerenciador de Livros:\n ");
        System.out.println("[1]- Adicionar Livro\n[2]- Listar todos os livros cadastrados\n[3]- Atualizar Livro\n[4]- Remover livro\n[5]- Encerrar Programa");
        int entradaOpcao = entradaLivro.nextInt();
        entradaLivro.nextLine();

        switch (entradaOpcao) {
            case 1:
                System.out.println("Adicionando livro...");
                System.out.println("ISBN:");
                String ISBN = entradaLivro.nextLine();
                System.out.println("Titulo:");
                String titulo = entradaLivro.nextLine();
                System.out.println("Autor:");
                String autor = entradaLivro.nextLine();
                System.out.println("Ano de publicação:");
                int anoDePublicacao = entradaLivro.nextInt();

                Livros novoLivro = new Livros(ISBN,titulo,autor,anoDePublicacao);
                if(!meuGerenciador.adicionarLivro(novoLivro)){
                    System.out.println("Erro, livro já existente!");
                    break;
                }
                else{
                System.out.println("Livro adicionado com sucesso!");
                }
                break;
            case 2:
                System.out.println("Lista de Livros:");
                List<Livros> listaDelivros = meuGerenciador.obterLivrosCadastrados();
                listaDelivros.forEach(System.out::println);
                break;
            case 3:

                    System.out.println("Insirá o ISBN do livro a ser atualizado:\nISBN: ");
                    String ISBNBusca = entradaLivro.nextLine();
                    if (meuGerenciador.obterLivroPorISBN(ISBNBusca) != null) {
                        System.out.println("Escolha a opcao a ser atualizada: ");
                        System.out.println("[1]- Atualizar tudo\n[2]- Atualizar titulo\n[3]- Atualizar autor");
                        int opcaoAtualizar = entradaLivro.nextInt();
                        entradaLivro.nextLine();
                        if (opcaoAtualizar == 1) {
                            System.out.println("Novo titulo: ");
                            String novoTitulo = entradaLivro.nextLine();
                            System.out.println("Novo autor:");
                            String novoAutor = entradaLivro.nextLine();
                            meuGerenciador.atualizarLivroCompleto(ISBNBusca, novoTitulo, novoAutor);
                            System.out.println("Atualização concluida!");
                            break;
                        }
                        if (opcaoAtualizar == 2) {
                            System.out.println("Novo titulo:");
                            String novoTitulo = entradaLivro.nextLine();
                            meuGerenciador.atualizarLivroTitulo(ISBNBusca, novoTitulo);
                            System.out.println("Atualização concluida!");
                            break;
                        }
                        if (opcaoAtualizar == 3) {
                            System.out.println("Novo autor:");
                            String novoAutor = entradaLivro.nextLine();
                            meuGerenciador.atualizarLivroAutor(ISBNBusca, novoAutor);
                            System.out.println("Atualização concluida!");
                            break;
                        }
                    }
                    System.out.println("Erro, opção invalida!\ntente novamente!");
                break;
            case 4:
                System.out.println("Insirá o ISBN para remover o livro:");
                String ISBNParaRemover = entradaLivro.nextLine();
                meuGerenciador.removerLivro(ISBNParaRemover);
                System.out.println("Removido com Sucesso!");
                break;
            case 5:
                System.out.println("Encerrando....");
                entradaLivro.close();
                return;
            default:
                System.out.println("Opção inválida,tente novamente!");
        }
       }
     }
}
