package Models;
import java.util.ArrayList;

public class GerenciadorPetshop {

    private ArrayList<EntityPetshop> listaDeCadastro = new ArrayList<>();

    public GerenciadorPetshop() {
        this.listaDeCadastro = new ArrayList<>();
    }

    // Adiciona um novo cadastro na ArrayList
    public boolean adicionarCadastro(EntityPetshop novoCadastro) {
        for (EntityPetshop cliente : listaDeCadastro) {
            if (cliente.getCPF() == novoCadastro.getCPF()) {
                // Se o CPF já existir, não adiciona e retorna false
                return false;
            }
        }
        listaDeCadastro.add(novoCadastro);
        System.out.println("Cadastro adicionado: " + novoCadastro.getCliente());
        return true; // Indica que o cliente foi adicionado com sucesso
    }
    public boolean listarTodos() {
        if (listaDeCadastro.isEmpty()) {
            return false; // Não há clientes cadastrados
        }

        System.out.println("Listando todos os cadastros:");
        for (EntityPetshop cadastro : listaDeCadastro) {
            System.out.println(cadastro);
        }
        return true; // Há clientes cadastrados
    }

    // Busca um cadastro pelo CPF
    public EntityPetshop buscarPorCPF(int cpfBusca) {
        for (EntityPetshop cadastro : listaDeCadastro) {
            if (cadastro.getCPF() == cpfBusca) {
                return cadastro; // Retorna o cadastro se o CPF for encontrado
            }
        }
        System.out.println("Cadastro não encontrado para o CPF: " + cpfBusca);
        return null;
    }

    public void atualizarCadastro(int cpfBusca, String novoNome, String novoAnimal, String novoTipoAnimal) {
    EntityPetshop entityPetshopDentroDaLista = buscarPorCPF(cpfBusca);
    if (entityPetshopDentroDaLista != null) {
        entityPetshopDentroDaLista.setCliente(novoNome);
        entityPetshopDentroDaLista.setAnimal(novoAnimal);
        entityPetshopDentroDaLista.setTipoDeAnimal(novoTipoAnimal);
    }
        System.out.println("Cadastro atualizado com successo.");
    }
    // Remove um cadastro pelo CPF
    public void removerCadastro(int cpfBusca) {
        // Usando a remoção via removeIf, que remove elementos da lista que satisfazem a condição
        boolean removido = listaDeCadastro.removeIf(cadastro -> cadastro.getCPF() == cpfBusca);

        if (removido) {
            System.out.println("Cadastro removido para o CPF: " + cpfBusca);
        } else {
            System.out.println("Cadastro não encontrado para remover.");
        }
    }
    public void agendamento(int cpfBusca, int agendarServico, int atualizarStatus) {
    EntityPetshop entityPetshopDentroDalista = buscarPorCPF(cpfBusca);
    if (entityPetshopDentroDalista != null) {
        entityPetshopDentroDalista.setTipoDeServico(agendarServico);
        entityPetshopDentroDalista.setStatusDoServico(atualizarStatus);
    }
    }
    public ArrayList<EntityPetshop> getListaDeCadastro() {
        return listaDeCadastro;
    }

}