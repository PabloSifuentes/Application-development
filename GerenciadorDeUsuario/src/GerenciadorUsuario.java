import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
    //Atributos

    private List<Usuario> usuariosList = new ArrayList<>();

    //Método CRUD

   public void adicionarUsuario(Usuario usuario) {
       usuariosList.add(usuario);
    }
    public void obterTodosUsuarios() {
       for(Usuario user : usuariosList)
           System.out.println(usuariosList);
    }
    public Usuario obterUsuarioPorId(String id) {
        for (Usuario user : usuariosList) {
            if (user.getId() == id) {
                return user;
            }
        }
    return null;
    }
    public void atualizarUsuario(String id,String novoNome, String novoEmail) {
       Usuario atualizandoUser = obterUsuarioPorId(id);
       if(atualizandoUser != null) {
           atualizandoUser.setNome(novoNome);
           atualizandoUser.setEmail(novoEmail);
       }
    }






}
