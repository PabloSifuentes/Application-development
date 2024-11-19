package edu.senai.br.projetosaiot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/projetoSA"; // Substitua com seu URL do banco
    private static final String USER = "root";  // Seu usuário do banco
    private static final String PASS = ""; // Sua senha do banco

    // Método para conectar ao banco de dados
    public static Connection conectar() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Conexão bem-sucedida com o banco de dados.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw e;
        }
    }

    // Método para inserir dados no banco
    public static void inserirDados(String distancia, String turbidez, String temperatura, String dataHora) {
        String query = "INSERT INTO qualidade_agua (distancia, turbidez, temperatura, data_hora) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = conectar(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, distancia);
            stmt.setString(2, turbidez);
            stmt.setString(3, temperatura);
            stmt.setString(4, dataHora);

            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados no banco: " + e.getMessage());
        }
    }
}
