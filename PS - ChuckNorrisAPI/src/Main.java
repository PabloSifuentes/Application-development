import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            String piada = obterPiadaChuchNorris();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String obterPiadaChuchNorris() throws IOException {
        // URL da API do Chuck Norris
        String apiUrl = "https://api.chucknorris.io/jokes/random";

        //Fazendo a requisicao GET para API
        HttpURLConnection conexao = (HttpURLConnection) new URL(apiUrl).openConnection();
        conexao.setRequestMethod("GET");

        //Lendo a resposta da API
        BufferedReader leitor = new BufferedReader(
                new InputStreamReader(conexao.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String linha;
        while ((linha = leitor.readLine()) != null){
            resposta.append(linha);
        }
        leitor.close();

        //Extraindo a piada do JSON
        int inicioDoIndice = resposta.indexOf("\"value\":") + ("\"value\":".length());
        int fimDoIndice = resposta.lastIndexOf("\"");
        return resposta.substring(inicioDoIndice, fimDoIndice);
    }
}