import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {

        try { // URL da API do Chuck Norris
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

            String piada = obterPiadaChuchNorris(resposta.toString());
            System.out.println(piada);

            String piadaTraduzida = traduzirParaPortuguese(piada);
            System.out.println(piadaTraduzida);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para extrair a piada do JSON retornado pela API.
     * @param resposta Resposta da API no formato String.
     * @return A piada extraida da resposta da API.
     * */

    private static String obterPiadaChuchNorris(String resposta) {


        //Extraindo a piada do JSON
        int inicioDoIndice = resposta.indexOf("\"value\":") + ("\"value\":".length());
        int fimDoIndice = resposta.lastIndexOf("\"");
        return resposta.substring(inicioDoIndice, fimDoIndice);
    }
    /**
     * Método para traduzir a piada para o português usando a API do Google Translate.
     * @param piadaParaTraduzir A piada a ser traduzida.
     * @return A piada traduzida para o português.
     */
    private static String traduzirParaPortuguese(String piadaParaTraduzir) {
        try {
            // URL da API do Google Translate
            String apiUrl = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=";

            // Fazendo a requisição GET para a API do Google Translate
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl + URLEncoder.encode(piadaParaTraduzir, "UTF-8")).openConnection();
            connection.setRequestMethod("GET");

            // Lendo a resposta da API
            BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();


            // Extraindo a tradução do JSON retornado pela API
            String traducao = resposta.substring(5, resposta.indexOf("\",\""));

            // Retornando a tradução
            return traducao;

        } catch (IOException e) {
            return "Erro ao traduzir a piada para o português.";
        }
    }

}