public class GerenciamentoEleicao {
    private Candidato[] candidatos;
    private int votosNulos;
    private int votosBrancos;
    private int totalVotos;

    public GerenciamentoEleicao() {
        this.candidatos = new Candidato[6];
        candidatos[0] = new Candidato("Ana");
        candidatos[1] = new Candidato("Pedro");
        candidatos[2] = new Candidato("Rita");
        candidatos[3] = new Candidato("Alfredo");
        candidatos[4] = new Candidato("Regina");
        candidatos[5] = new Candidato("Ricardo");
        this.votosNulos = 0;
        this.totalVotos = 0;
        this.votosBrancos = 0;
    }

    public void votar(int voto, int turma) {
        if (voto == 0) {
            votosNulos++;
        } else if (voto == 10) {
            votosBrancos++;
        } else if (voto >= 1 && voto <= 6) {
            candidatos[voto - 1].adicionarVoto(turma);
        } else {
            System.out.printf("Candidato inválido, informe o número correto.");
            return; // Retorna sem contar o voto
        }
        totalVotos++;
    }

    public void mostrarResultados() {
        int votosValidos = totalVotos - votosNulos - votosBrancos;

        System.out.printf(" Total de eleitores: " + totalVotos);
        System.out.printf(" Votos válidos: " + votosValidos);
        System.out.println(" Votos nulos: " + votosNulos);
        System.out.println(" Votos em branco: " + votosBrancos);

        double percValido = (double) votosValidos / totalVotos * 100;
        double percNulos = (double) votosNulos / totalVotos * 100;
        double percBrancos = (double) votosBrancos / totalVotos * 100;

        System.out.println("porcentagem de votos válidos: " + percValido + "%");
        System.out.println("porcentagem de votos nulos: " + percNulos + "%");
        System.out.println("porcentagem de votos brancos: " + percBrancos + "%");

        for (Candidato candidato : candidatos) {
            double percCandidato = (double) candidato.getVotos() / totalVotos * 100;
            System.out.println(candidato.getNome() + "Recebeu " + candidato.getVotos() + " votos (" + percCandidato + "%)");
        }

        for (Candidato candidato : candidatos) {
            System.out.println("\n Votos por turma para " + candidato.getNome() + ":");
            for (int turma = 1; turma <= 3; turma++) {
                double percPorTurma = (double) candidato.getVotosPorTurma(turma) / totalVotos * 100;
                System.out.println("" +
                        "┏━━━━━━━━━━━━━━━━━━━━┑\n" +
                        " Turma " + turma + ": " + percPorTurma + "%\n" +
                        "┗━━━━━━━━━━━━━━━━━━━━┙");
            }
        }
    }
}