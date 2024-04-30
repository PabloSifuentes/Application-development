package Models;

import Models.Carro;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCarro {

    //Atributos
    private List<Carro> listaDeCarros = new ArrayList<>();

    //Métodos

    public boolean adicionarCarro(Carro carroInformado) {
        for (Carro carroDentroDaLista : listaDeCarros) {
            if (carroDentroDaLista.getPlaca().equals(carroInformado.getPlaca())) {
                return false;
            }
        }
        listaDeCarros.add(carroInformado);
        return true;
    }

    public List<Carro> getListaDeCarros() {
        return listaDeCarros;
    }
    private Carro obterCarrPorPlaca(String placaFornecidoPorBusca) {
        for(Carro carroDentroDaLista : listaDeCarros) {
            if(carroDentroDaLista.getPlaca().equals(placaFornecidoPorBusca)) {
                return carroDentroDaLista;
            }
        }
        return null;
    }
    public void atualizarCarro(String modelo, String cor) {
    
    }
}
