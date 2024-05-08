import Models.Artigos;
import Models.gerenciadorDeArtigos;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaArtigos = new Scanner(System.in);
        gerenciadorDeArtigos meuGerenciador = new gerenciadorDeArtigos();

        while(true) {
            System.out.println("Gerenciador De Arquivos\n");
            System.out.println("[1]- Adicionar Artigos\n[2]- Listar Artigos cadastrados\n[3]- Atualizar Artigos\n[4]- Remover Artigo\n[5]- Encerrar Programa\n");
            int opcaoMenu = entradaArtigos.nextInt();
            entradaArtigos.nextLine();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("Preeencha as informações a baixo:");
                    System.out.println("ID:");
                    int id = entradaArtigos.nextInt();
                    entradaArtigos.nextLine();
                    System.out.println("Titulo:");
                    String titulo = entradaArtigos.nextLine();
                    System.out.println("Autor:");
                    String autor = entradaArtigos.nextLine();
                    System.out.println("Data de Publicação:");
                    int dataDePublicacao = entradaArtigos.nextInt();
                    entradaArtigos.nextLine();

                    Artigos artigoAdicionado = new Artigos(id,titulo,autor,dataDePublicacao);

                    if(!meuGerenciador.adicionarArtigos(artigoAdicionado)) {
                        System.out.println("Erro,opção inválida.\nTente novamente.");
                    }
                    else {
                        System.out.println("Artigo adicionado com sucesso!");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Todos Artigos Cadastrados:");
                    List<Artigos> listaDeArtigos = meuGerenciador.obterArtigosCadastrados();
                    listaDeArtigos.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Insirá o ID do Artigo a ser atualizado:");
                    int idBusca = entradaArtigos.nextInt();
                    entradaArtigos.nextLine();
                    System.out.println("Novo Titulo:");
                    String novoTitulo = entradaArtigos.nextLine();
                    System.out.println("Novo Autor:");
                    String novoAutor = entradaArtigos.nextLine();
                    System.out.println("Nova Data de publicação:");
                    int novaData = entradaArtigos.nextInt();
                    entradaArtigos.nextLine();

                    meuGerenciador.atualizarArtigos(idBusca,novoTitulo, novoAutor, novaData);
                    break;
                case 4:
                    System.out.println("Insirá o ID do Artigo a ser removido:");
                    int idRemovido = entradaArtigos.nextInt();
                    meuGerenciador.removerArtigo(idRemovido);
                    System.out.println("Artigo removido com sucesso!");
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção Inexistente, tente novamente:");
                    break;
            }




        }




    }
}
