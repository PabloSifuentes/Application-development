public class Candidato {

    private String nome;
    private int votos;
    private int[] votosPorTurma;

    public Candidato(String nome) {
        this.nome = nome;
        this.votos = 0;
        this.votosPorTurma = new int[3];
    }


    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void adicionarVoto(int turma) {
        this.votos++;
        this.votosPorTurma[turma - 1]++; // A turma está na posição 0, a turma 2 na posição 1 e a turma 3 na posição 2.
    }

    public int getVotosPorTurma(int turma) {
        return votosPorTurma[turma - 1];
    }
}
