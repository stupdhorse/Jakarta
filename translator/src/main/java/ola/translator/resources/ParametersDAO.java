/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.translator.resources;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParametersDAO {
    private static final String DB_URL = "jdbc:h2:~/test_translator";
    private static final String DB_USER = "Misiek";
    private static final String DB_PASSWORD = "Groomer";

    public ParametersDAO() throws SQLException {
        DatabaseInitializer.initializeDatabase();
    }

    public void addWord(Word word) throws SQLException {
        String sql = "INSERT INTO operations (pl, eng, de,timestamp) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, word.getPL()); 
            stmt.setString(2, word.getENG()); 
            stmt.setString(3, word.getDE()); 
            stmt.setTimestamp(4, Timestamp.valueOf(word.getTimestamp()));
            stmt.executeUpdate();
        }
    }

    public List<Word> getDictionary() throws SQLException {
        List<Word> words = new ArrayList<>();
        String sql = "SELECT pl, eng, de, timestamp FROM operations ORDER BY timestamp DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String pl = rs.getString("pl");  
                String eng = rs.getString("eng");  
                String de = rs.getString("de");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                words.add(new Word(pl, eng, de,timestamp.toLocalDateTime()));
            }
        }
        return words;
    }
}
