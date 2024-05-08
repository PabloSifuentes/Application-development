package Models;

import java.util.ArrayList;
import java.util.List;

public class gerenciadorDeArtigos {
    List<Artigos> listaDeArtigos = new ArrayList<>();

    public boolean adicionarArtigos(Artigos artigosAdicionado) {
        for(Artigos artigoDentroDalista : listaDeArtigos) {
            if(artigoDentroDalista.equals(artigosAdicionado)) {
                return false;
            }
        }
        listaDeArtigos.add(artigosAdicionado);
        return true;
    }
    public List<Artigos> obterArtigosCadastrados() {
        return listaDeArtigos;
    }

    public Artigos obterArtigoPorID(int idBusca) {
        for(Artigos artigoDentroDaLista : listaDeArtigos) {
            if(artigoDentroDaLista.getId() == idBusca) {
                return artigoDentroDaLista;
            }
        }
        return null;
    }
    public void atualizarArtigos(int idBusca, String novoTitulo, String novoAutor, int novaDataDePublicacao) {
        Artigos artigoDentroDaLista = obterArtigoPorID(idBusca);
            if(artigoDentroDaLista != null) {
                artigoDentroDaLista.setTitulo(novoTitulo);
                artigoDentroDaLista.setAutor(novoAutor);
                artigoDentroDaLista.setDataDePublicacao(novaDataDePublicacao);
            }
    }
    public void removerArtigo(int idBusca){
        listaDeArtigos.removeIf(artigos -> artigos.getId() == idBusca);
    }





}
