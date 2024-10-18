import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GerenciamentoEleicao eleicao = new GerenciamentoEleicao();
        Scanner entradaDeVoto = new Scanner(System.in);
        int eleitores = 50;
        boolean controleVoto = true; // controla se a votação ainda está ativa

        // Loop para coletar os votos de até 50 eleitores
        for (int i = 0; i < eleitores && controleVoto; i++) {
            System.out.println("Eleitor " + (i + 1) + ":");

            // Informar turma
            System.out.println("Selecione a turma: \n" +
                    "┏━━━━━━━━━━━━━━━━━━━━┑\n" +
                    "┃  1 - Primeiro      ┃\n" +
                    "┃  2 - Segundo       ┃\n" +
                    "┃  3 - Terceiro      ┃\n" +
                    "┗━━━━━━━━━━━━━━━━━━━━┙");
            int turma = entradaDeVoto.nextInt();
            while (turma < 1 || turma > 3) {
                System.out.println("Turma inválida. Informe a turma correta (1, 2 ou 3):");
                turma = entradaDeVoto.nextInt();
            }

            // Informar voto
            System.out.println("Informe o número da chapa que deseja votar: ");
            System.out.println("" +
                    "┏━━━━━━━━━━━━━━━━━━━━┑\n" +
                    "┃ [1] - Ana          ┃\n" +
                    "┃ [2] - Pedro        ┃\n" +
                    "┃ [3] - Rita         ┃\n" +
                    "┃ [4] - Alfredo      ┃\n" +
                    "┃ [5] - Regina       ┃\n" +
                    "┃ [6] - Ricardo      ┃\n" +
                    "┃ [0] - Voto Nulo    ┃\n" +
                    "┃ [10] - Voto Branco ┃\n" +
                    "┗━━━━━━━━━━━━━━━━━━━━┙");
            int voto = entradaDeVoto.nextInt();
            while (voto != 0 && voto != 10 && (voto < 1 || voto > 6)) {
                System.out.println("Voto inválido. Informe o número correto. ");
                voto = entradaDeVoto.nextInt();
            }

            // Contabilizar voto
            eleicao.votar(voto, turma);

            // Perguntar se deseja continuar a votação
            System.out.println("Deseja continuar votando?\n" +
                    "┏━━━━━━━━━━━━━┑\n" +
                    "┃ [0] - Sim   ┃\n" +
                    "┃ [1] - Não   ┃\n" +
                    "┗━━━━━━━━━━━━━┙");
            int opcao = entradaDeVoto.nextInt();

            if (opcao == 1) {  // Se o usuário escolher encerrar
                System.out.println("Encerrando votação...");
                controleVoto = false;  // Isso encerra o loop for
            } else if (opcao != 0) {  // Qualquer valor fora de [0] e [1] é inválido
                System.out.println("Opção inválida, tente novamente!");
                i--;  // Volta o contador para refazer a votação do mesmo eleitor
            }
        }
        // Mostrar os resultados ao final
        eleicao.mostrarResultados();
        entradaDeVoto.close();
    }
}
