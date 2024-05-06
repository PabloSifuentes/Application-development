package Models;

public class Usuario {

    //Atributos de Usuario
   private String id;

   private String nome;

   private String email;

    /**
     * Construtor com argumentos do objeto Usuário
     * @param id Identificador do Usuário
     * @param nome Nome do Usuários
     * @param email Email do Usuário
     */
    public Usuario(String id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    //Métodos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
