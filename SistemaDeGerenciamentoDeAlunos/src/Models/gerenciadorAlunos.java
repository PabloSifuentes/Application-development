package Models;

import java.util.ArrayList;
import java.util.List;

public class gerenciadorAlunos {
    List<Alunos> listaDeAlunos = new ArrayList<>();

    public boolean adicionarAlunos(Alunos alunosAdicionado) {
        for(Alunos alunosDentroDaLista : listaDeAlunos) {
            if(alunosDentroDaLista.equals(alunosAdicionado)) {
                return false;
            }
        }
        listaDeAlunos.add(alunosAdicionado);
        return true;
    }
    public List<Alunos>obterTodosAlunos() {
      return listaDeAlunos;
    }
    public Alunos obterAlunoPorMatricula(int matriculaPorBusca) {
        for(Alunos alunoDentroDaLista : listaDeAlunos) {
            if(alunoDentroDaLista.equals(matriculaPorBusca)) {
                return alunoDentroDaLista;
            }
        }
        return null;
    }
    public void atualizarAluno(int matriculaPorBusca, String novoNome, String novoCurso) {
       Alunos alunoDentroDaLista = obterAlunoPorMatricula(matriculaPorBusca);
           if(alunoDentroDaLista != null) {
               alunoDentroDaLista.setNome(novoNome);
               alunoDentroDaLista.setCurso(novoCurso);
           }
        }
    public void removerAluno(int matriculaRemover) {
        listaDeAlunos.removeIf(alunos -> alunos.getMatricula() == matriculaRemover);
    }
}
