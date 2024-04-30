
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
    public void atualizarUsuario(String idParaBuscaOUsuario,String novoNome, String novoEmail) {
        Usuario atualizandoUsuario = obterUsuarioPorId(idParaBuscaOUsuario);
        if (atualizandoUsuario != null) {
            atualizandoUsuario.setNome(novoNome);
            atualizandoUsuario.setEmail(novoEmail);
        }
    }
    public void removerUsuario(String idParaRemover) {
        usuariosList.removeIf(usuario -> usuario.getId().equals(idParaRemover));
            }
}
