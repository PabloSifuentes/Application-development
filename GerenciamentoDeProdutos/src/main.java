import Models.Produto;
import Models.gerenciadorDeProduto;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner entradaProduto = new Scanner(System.in);
    gerenciadorDeProduto meuGerenciador = new gerenciadorDeProduto();

    while(true) {
        System.out.println("Gerenciador de Produtos.\n");
        System.out.println("[1]- Adicionar Produto\n[2]- Lista de todos produtos\n[3]- Atualizar produto\n[4]- Remover produto\n[5]- Encerrar Programa");
        int opcaoRecebeProduto = entradaProduto.nextInt();
        entradaProduto.nextLine();

        switch (opcaoRecebeProduto) {
            case 1:
                System.out.println("Insirá as informações a baixo:");
                System.out.println("Código:");
                int codigo = entradaProduto.nextInt();
                entradaProduto.nextLine();
                System.out.println("Nome:");
                String nome = entradaProduto.nextLine();
                System.out.println("Categoria:");
                String categoria = entradaProduto.nextLine();
                System.out.println("Preço:");
                double preco = entradaProduto.nextDouble();
                Produto produtoAdicionado = new Produto(codigo, nome, categoria, preco);

                if(!meuGerenciador.adicionarProduto(produtoAdicionado)) {
                    System.out.println("Erro, opção inválida, tente novamente!");
                    break;
                }
                else {
                    System.out.println("Produto adicionado com sucesso!");
                }
                break;
            case 2:
                System.out.println("Todos produtos cadastrados:");
                List<Produto> listaDosProdutos = meuGerenciador.listarProdutos();
                listaDosProdutos.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Insirá o código do produto a ser atualizado:");
                int codigoParaAtualizar = entradaProduto.nextInt();
                entradaProduto.nextLine();
                if (meuGerenciador.obterProdutoPorCodigo(codigoParaAtualizar) == null) {
                    System.out.println("Erro, opção inválida.");
                } else {
                    System.out.println("Nome: ");
                    String novoNome = entradaProduto.nextLine();
                    System.out.println("Categoria: ");
                    String novaCategoria = entradaProduto.nextLine();
                    System.out.println("Preço: ");
                    double novoPreco = entradaProduto.nextInt();
                    entradaProduto.nextLine();
                    meuGerenciador.atualizarProduto(codigoParaAtualizar,novoNome, novaCategoria, novoPreco);
                    System.out.println("Atualizado com sucesso!");
                    break;
                }
                break;
            case 4:
                System.out.println("Insirá o código do produto a ser removido:");
                int produtoRemovido = entradaProduto.nextInt();
                if(meuGerenciador.obterProdutoPorCodigo(produtoRemovido) == null){
                    System.out.println("Erro, opção inválida.\ntente novamente!");
                }
                else {
                meuGerenciador.reomoverProduto(produtoRemovido);
                    System.out.println("Produto removido!");
                }
                break;
            case 5:
                System.out.println("Encerrando...");
                entradaProduto.close();
                return;
        }



    }







    }
}
