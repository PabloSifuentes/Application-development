package Models;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPetshop {

private List<EntityPetshop> listaDeCadastro = new ArrayList<>();

public GerenciadorPetshop() {
}

public void cadastrarClientes(EntityPetshop clienteAdicionado) {
    for(EntityPetshop cadastroDentroDaLista : listaDeCadastro) {
        if (cadastroDentroDaLista.getCPF().equals(clienteAdicionado.getCPF())) {
            System.out.println("Erro: Cliente já cadastrado!");
            return;
        }
    }
            listaDeCadastro.add(clienteAdicionado);
            System.out.println("Cliente cadastrado com sucesso!");
}
public void obterTodosClientesCadastrados() {
    if (listaDeCadastro.isEmpty()) {
        System.out.println("Não há livros na lista!");
    }
    listaDeCadastro.forEach(System.out::println);
}
private EntityPetshop obterClietePorCPF(int cpfBusca) {
    for (EntityPetshop cadastroDentroDaLista : listaDeCadastro) {
        if (cadastroDentroDaLista.getCPF().equals(cpfBusca)) {
            return cadastroDentroDaLista;
        }
    }
    System.out.println("Cadastro não encontrado.");
    return null;
}
public void atualizarCadastro (int cpfBusca, String novoAnimal, String novoTipoDeAnimal) {
    EntityPetshop cadastroDentroDaLista = obterClietePorCPF(cpfBusca);
    if (cadastroDentroDaLista != null) {
        cadastroDentroDaLista.setAnimal(new String[]{novoAnimal});
        cadastroDentroDaLista.setTipoDeAnimal(new String[]{novoTipoDeAnimal});
        System.out.println("Cadastro atualizado com sucesso!");
        System.out.println(cadastroDentroDaLista);
    } else {
        System.out.println("Cadastro não encontrado.");
    }
}
public void removerCadastro(int cpfBusca) {
    boolean removido = listaDeCadastro.removeIf(entityPetshop -> entityPetshop.getCPF().equals(cpfBusca));
    if (removido) {
        System.out.println("Cadastro excluido com sucesso!");
    } else {
        System.out.println("Cadastro com CPF: " + cpfBusca + "não encontrado.");
    }
}
public void gerenciarServico(int cpfBusca, String tipoServico, String statusServico) {
    EntityPetshop cliente = obterClietePorCPF(cpfBusca);
    if (cliente != null) {
        cliente.setTipoDeServiço(new String[]{tipoServico});
        cliente.setStatusDoServiço(new String[]{statusServico});
        System.out.println("Serviço de " + tipoServico + " para o cliente de CPF " + cpfBusca + " está agora " + statusServico + ".");
    } else {
        System.out.println("Cliente não encontrado para o CPF: " + cpfBusca);
    }
}
}
