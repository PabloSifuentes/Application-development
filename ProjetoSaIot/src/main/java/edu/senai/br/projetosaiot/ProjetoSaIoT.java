/*
 * ProjetoSaIoT.java
 * 
 * Descrição:
 * Este programa utiliza MQTT e uma interface gráfica em Java Swing para exibir dados de sensores relacionados à qualidade da água,
 * como temperatura, turbidez e distância. O programa se conecta a um broker MQTT e recebe dados no formato JSON sobre esses sensores
 * através do tópico "le_dados_qualidade_agua". O aplicativo exibe os valores recebidos em tempo real em campos de texto e os armazena
 * em um banco de dados, após garantir que todos os dados necessários foram recebidos. O programa também possui um controle de timeout
 * para garantir que os dados sejam recebidos em um intervalo específico.
 *
 * Nome do grupo: G
 * Integrantes: Willia, Pablo, Carlos
 * 
 * Data: Novembro 2024
 */

package edu.senai.br.projetosaiot;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import org.json.JSONArray;
import org.json.JSONException;

public class ProjetoSaIoT {

    // Definições de constantes para configuração do cliente MQTT e tópico
    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String CLIENT_ID = "JavaGUIClient";
    private static final String TOPIC = "le_dados_qualidade_agua";

    // Componentes gráficos
    private JFrame frame;
    private MqttClient mqttClient;
    private JTextField distanciaField, temperaturaField, turbidezField, timestampField;

    // Variáveis para armazenar os dados recebidos
    private String temperatura = null;
    private String turbidez = null;
    private String distancia = null;
    private String timestamp = null;

    // Variáveis de controle de tempo
    private long lastReceivedTimestamp = 0;  // Controle do tempo de espera
    private static final long TIMEOUT = 10000; // Tempo limite em milissegundos (10 segundos)

    // Construtor da classe
    public ProjetoSaIoT() {
        createGUI();
    }

    // Método para criar a interface gráfica (GUI)
    private void createGUI() {
        frame = new JFrame("MQTT Sensor Data");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 9, 5);

        // Labels e campos de texto para as variáveis
        JLabel distanciaLabel = new JLabel("Distância (cm):");
        distanciaField = new JTextField(10);
        distanciaField.setEditable(false);

        JLabel temperaturaLabel = new JLabel("Temperatura (°C):");
        temperaturaField = new JTextField(10);
        temperaturaField.setEditable(false);

        JLabel turbidezLabel = new JLabel("Turbidez (NTU):");
        turbidezField = new JTextField(10);
        turbidezField.setEditable(false);

        JLabel timestampLabel = new JLabel("Timestamp:");
        timestampField = new JTextField(10);
        timestampField.setEditable(false);

        // Botão para iniciar a leitura
        JButton iniciarButton = new JButton("Iniciar Leitura");
        iniciarButton.addActionListener(e -> setupMQTTClient());

        // Adicionando os componentes na interface gráfica
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(distanciaLabel, gbc);
        gbc.gridx = 1;
        frame.add(distanciaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(temperaturaLabel, gbc);
        gbc.gridx = 1;
        frame.add(temperaturaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(turbidezLabel, gbc);
        gbc.gridx = 1;
        frame.add(turbidezField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(timestampLabel, gbc);
        gbc.gridx = 1;
        frame.add(timestampField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(iniciarButton, gbc);

        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para configurar o cliente MQTT e começar a receber dados
    private void setupMQTTClient() {
        try {
            // Criando cliente MQTT e conectando ao broker
            mqttClient = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("Connecting to broker: " + BROKER_URL);
            mqttClient.connect(connOpts);
            System.out.println("Connected");

            // Subscrição ao tópico e processamento das mensagens recebidas
            mqttClient.subscribe(TOPIC, (topic, message) -> {
                try {
                    // Recebendo e tratando o payload da mensagem
                    String msg = new String(message.getPayload());
                    System.out.println("Payload recebido: " + msg);

                    // Convertendo a mensagem para um JSONArray
                    JSONArray jsonArray = new JSONArray(msg);

                    // Iterando pelos objetos dentro do array
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        // Verificando e processando os dados do payload
                        if (jsonObject.has("variable") && jsonObject.has("value") && jsonObject.has("timestamp")) {
                            String variable = jsonObject.getString("variable");
                            String value = jsonObject.getString("value");
                            timestamp = jsonObject.getString("timestamp");

                            // Se o timestamp for nulo ou vazio, substituímos pelo timestamp atual
                            if (timestamp == null || timestamp.isEmpty()) {
                                timestamp = getCurrentTimestamp(); // Função que retorna o timestamp atual
                            }

                            // Atualizando as variáveis temporárias com os valores recebidos
                            if (variable.equals("valor_distancia")) {
                                distancia = value;
                                lastReceivedTimestamp = System.currentTimeMillis(); // Atualiza o tempo da última leitura
                                SwingUtilities.invokeLater(() -> distanciaField.setText(value));
                            } else if (variable.equals("valor_temperatura")) {
                                temperatura = value;
                                lastReceivedTimestamp = System.currentTimeMillis(); // Atualiza o tempo da última leitura
                                SwingUtilities.invokeLater(() -> temperaturaField.setText(value));
                            } else if (variable.equals("valor_turbidez")) {
                                turbidez = value;
                                lastReceivedTimestamp = System.currentTimeMillis(); // Atualiza o tempo da última leitura
                                SwingUtilities.invokeLater(() -> turbidezField.setText(value));
                            }
                            // Atualizando o timestamp na interface gráfica
                            SwingUtilities.invokeLater(() -> timestampField.setText(timestamp));
                        }
                    }

                    // Verificando se todas as variáveis foram recebidas
                    if (temperatura != null && turbidez != null && distancia != null) {
                        // Se tivermos todas as variáveis e o tempo não expirou, insira no banco de dados
                        try {
                            // Chama o método para inserir os dados no banco de dados
                            ConexaoDB.inserirLeitura(
                                    Float.parseFloat(temperatura),
                                    Integer.parseInt(turbidez),
                                    Integer.parseInt(distancia),
                                    timestamp
                            );

                            // Após a inserção bem-sucedida, resetamos as variáveis temporárias
                            temperatura = null;
                            turbidez = null;
                            distancia = null;
                            timestamp = null;
                            lastReceivedTimestamp = 0; // Resetando o tempo
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao processar e inserir dados no banco: " + e.getMessage());
                        }
                    } else {
                        // Se faltarem variáveis ou o timeout for atingido, não insira nada
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - lastReceivedTimestamp > TIMEOUT) {
                            System.out.println("Timeout atingido sem receber todas as variáveis. Tentando novamente.");

                            // Resetar variáveis se o tempo limite for atingido
                            temperatura = null;
                            turbidez = null;
                            distancia = null;
                            timestamp = null;
                            lastReceivedTimestamp = 0;
                        }
                    }

                } catch (JSONException e) {
                    System.out.println("Erro ao processar o payload: " + e.getMessage());
                }
            });

        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    // Função para obter o timestamp atual (formato: yyyy-MM-dd HH:mm:ss)
    private String getCurrentTimestamp() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return sdf.format(date);
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjetoSaIoT::new);
    }
}
