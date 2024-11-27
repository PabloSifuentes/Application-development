package edu.senai.br.projetosaiot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/saprojeto"; // Ajuste para seu banco de dados
    private static final String USER = "root"; // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = ""; // Substitua pela sua senha

    // Estabelece a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insere uma leitura no banco de dados (Temperatura, Turbidez, Distância)
    public static void inserirLeitura(double temperatura, int turbidez, int distancia, String timestamp) {
        String query = "INSERT INTO leituras_sensores (temperatura, turbidez, distancia, timestamp) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Definindo os parâmetros da query
            preparedStatement.setDouble(1, temperatura);
            preparedStatement.setInt(2, turbidez);
            preparedStatement.setInt(3, distancia);
            preparedStatement.setString(4, timestamp);

            // Executando a inserção
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Leitura inserida com sucesso!");
            } else {
                System.out.println("Erro ao inserir leitura.");
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão ou inserção no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Insere leitura individual da temperatura
    public static void inserirLeituraTemperatura(double temperatura, String timestamp) {
        String query = "INSERT INTO leituras_sensores (temperatura, timestamp) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Definindo os parâmetros da query
            preparedStatement.setDouble(1, temperatura);
            preparedStatement.setString(2, timestamp);

            // Executando a inserção
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Leitura de temperatura inserida com sucesso!");
            } else {
                System.out.println("Erro ao inserir leitura de temperatura.");
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão ou inserção no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Insere leitura individual da turbidez
    public static void inserirLeituraTurbidez(int turbidez, String timestamp) {
        String query = "INSERT INTO leituras_sensores (turbidez, timestamp) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Definindo os parâmetros da query
            preparedStatement.setInt(1, turbidez);
            preparedStatement.setString(2, timestamp);

            // Executando a inserção
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Leitura de turbidez inserida com sucesso!");
            } else {
                System.out.println("Erro ao inserir leitura de turbidez.");
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão ou inserção no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Insere leitura individual da distância
    public static void inserirLeituraDistancia(int distancia, String timestamp) {
        String query = "INSERT INTO leituras_sensores (distancia, timestamp) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Definindo os parâmetros da query
            preparedStatement.setInt(1, distancia);
            preparedStatement.setString(2, timestamp);

            // Executando a inserção
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Leitura de distância inserida com sucesso!");
            } else {
                System.out.println("Erro ao inserir leitura de distância.");
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão ou inserção no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
