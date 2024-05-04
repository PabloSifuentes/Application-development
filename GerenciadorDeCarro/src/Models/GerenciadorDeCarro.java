package Models;

import java.util.ArrayList;
import java.util.List;

public class gerenciadorDeCarro {

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

    public List<Carro> ObterTodosCarros() {
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
    public void atualizarCarro(String placaParaAtualizar, String novoModelo, String novaCor) {
        Carro carroParaAtualizar = obterCarrPorPlaca(placaParaAtualizar);
        if(carroParaAtualizar != null) {
            carroParaAtualizar.setCor(novaCor);
            carroParaAtualizar.setModelo(novoModelo);
        }

    }
    public void atualizarCarroModelo (String placaParaAtualizar, String novoModelo) {
        Carro carroParaAtualizar = obterCarrPorPlaca(placaParaAtualizar);
        if(carroParaAtualizar != null) {
            carroParaAtualizar.setModelo(novoModelo);
        }
    }
    public void atualizarCarroCor (String placaParaAtualizar, String novaCor) {
        Carro carroParaAtualizar = obterCarrPorPlaca(placaParaAtualizar);
        if(carroParaAtualizar != null) {
            carroParaAtualizar.setCor(novaCor);
        }
    }
    public void romoverCarro (String placaParaRemover) {
        listaDeCarros.removeIf(carro -> carro.getPlaca().equals(placaParaRemover));
    }
}
