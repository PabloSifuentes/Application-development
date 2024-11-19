package edu.senai.br.projetosaiot;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import org.json.JSONException;

public class ProjetoSaIoT {

    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String CLIENT_ID = "JavaGUIClient";
    private static final String TOPIC = "le_dados_qualidade_agua";
    private JFrame frame;
    private MqttClient mqttClient;
    private JTextField distanciaField, turbidezField, temperaturaField, dataHoraField;

    public ProjetoSaIoT() {
        createGUI();
        setupMQTTClient();
    }

    private void createGUI() {
        frame = new JFrame("MQTT Sensor Data");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel distanciaLabel = new JLabel("Distância (cm):");
        distanciaField = new JTextField(15);
        distanciaField.setEditable(false);

        JLabel turbidezLabel = new JLabel("Turbidez:");
        turbidezField = new JTextField(15);
        turbidezField.setEditable(false);

        JLabel temperaturaLabel = new JLabel("Temperatura (°C):");
        temperaturaField = new JTextField(15);
        temperaturaField.setEditable(false);

        JLabel dataHoraLabel = new JLabel("Data/Hora de Coleta:");
        dataHoraField = new JTextField(15);
        dataHoraField.setEditable(false);
        
        JLabel coletaLabel = new JLabel("Iniciar coleta:");
        JButton coletaButton = new JButton("Iniciar");

        // Define a ação do botão
        coletaButton.addActionListener(e -> {
    System.out.println("Coleta iniciada!");

    // Preenche o campo dataHoraField com a data e hora atuais
    String dataHora = java.time.LocalDateTime.now().toString();
    dataHoraField.setText(dataHora); // Atualiza o JTextField com a data e hora

    // Pegando os valores dos JTextFields
    String distancia = distanciaField.getText();
    String turbidez = turbidezField.getText();
    String temperatura = temperaturaField.getText();
    dataHora = dataHoraField.getText(); // Pega o valor atualizado do campo

    // Verifica se os campos estão preenchidos
    if (distancia.isEmpty() || turbidez.isEmpty() || temperatura.isEmpty() || dataHora.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Todos os campos devem estar preenchidos antes de salvar!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Insere os dados no banco de dados
    try {
        ConexaoDB.inserirDados(distancia, turbidez, temperatura, dataHora);
        JOptionPane.showMessageDialog(frame, "Dados salvos com sucesso no banco de dados!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(frame, "Erro ao salvar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
});



        // Adiciona os labels e text fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(distanciaLabel, gbc);
        gbc.gridx = 1;
        frame.add(distanciaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(turbidezLabel, gbc);
        gbc.gridx = 1;
        frame.add(turbidezField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(temperaturaLabel, gbc);
        gbc.gridx = 1;
        frame.add(temperaturaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(dataHoraLabel, gbc);
        gbc.gridx = 1;
        frame.add(dataHoraField, gbc);

         gbc.gridx = 0;
gbc.gridy = 4;
frame.add(coletaLabel, gbc);

gbc.gridx = 1;
frame.add(coletaButton, gbc);

      
        frame.setSize(350, 200); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setupMQTTClient() {
        try {
            mqttClient = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("Connecting to broker: " + BROKER_URL);
            mqttClient.connect(connOpts);
            System.out.println("Connected");

            mqttClient.subscribe(TOPIC, (topic, message) -> {
                try {
                    String msg = new String(message.getPayload());
                    System.out.println("Payload recebido: " + msg);

                    JSONObject jsonObject = new JSONObject(msg);

                    // Verifica se o objeto contém as chaves esperadas
                    if (jsonObject.has("distancia") && jsonObject.has("turbidez") && jsonObject.has("temperatura") && jsonObject.has("dataHora")) {
                        String distancia = jsonObject.getString("distancia");
                        String turbidez = jsonObject.getString("turbidez");
                        String temperatura = jsonObject.getString("temperatura");
                        String dataHora = jsonObject.getString("dataHora");

                        // Atualiza os campos na interface gráfica
                        SwingUtilities.invokeLater(() -> {
                            distanciaField.setText(distancia);
                            turbidezField.setText(turbidez);
                            temperaturaField.setText(temperatura);
                            dataHoraField.setText(dataHora);
                        });

                        // Insere os dados no banco de dados
                        ConexaoDB.inserirDados(distancia, turbidez, temperatura, dataHora);

                    } else {
                        System.out.println("Objeto JSON sem as chaves esperadas.");
                    }
                } catch (JSONException e) {
                    System.out.println("Erro ao processar o payload: " + e.getMessage());
                }
            });

        } catch (MqttException me) {
            System.out.println("Erro ao conectar no broker: " + me.getMessage());
            me.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjetoSaIoT::new);
    }
}