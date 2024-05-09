package Models;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
    //Atributos

    private List<Usuario> usuariosList = new ArrayList<>();

    //Método CRUD

   public boolean adicionarUsuario(Usuario usuarioInformado) {
       for (Usuario usuarioDentroDaLista : usuariosList) {
           if (usuarioDentroDaLista.getId().equals(usuarioInformado.getId())) {
               return false;
           }
       }
       usuariosList.add(usuarioInformado);
       return true;
   }
    public List<Usuario>ObterTodosUsuarios() {
       return usuariosList;
        }

    public Usuario obterUsuarioPorId(String idFornecidoBusca) {
        for (Usuario userDentroDaLista : usuariosList) {
            if (userDentroDaLista.getId().equals(idFornecidoBusca)) {
                return userDentroDaLista;
            }
        }
    return null;
    }
    public void atualizarUsuario(String idParaAtualizar,String novoNome, String novoEmail) {
        Usuario atualizandoUser = obterUsuarioPorId(idParaAtualizar);
        if (atualizandoUser != null) {
            atualizandoUser.setNome(novoNome);
            atualizandoUser.setEmail(novoEmail);
        }
    }
       public void removerUsuario(String idRemover) {
           usuariosList.removeIf(usuario -> usuario.getId().equals(idRemover));
               }
           }









