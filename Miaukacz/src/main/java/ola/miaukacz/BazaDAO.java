/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.miaukacz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BazaDAO {
    private static final String DB_URL = "jdbc:h2:~/test_copy";
    private static final String DB_USER = "Misiek";
    private static final String DB_PASSWORD = "Groomer";

    public BazaDAO() throws SQLException {
        initializeDatabase();
    }

    private void initializeDatabase() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS forms (" +
                "pesel VARCHAR(11) PRIMARY KEY, " +
                "answer1 VARCHAR(255), " +
                "answer2 VARCHAR(255), " +
                "created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    public void addForm(Form form) throws SQLException {
        String sql = "INSERT INTO forms (pesel, answer1, answer2, created_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, form.getPesel());
            stmt.setString(2, form.getAnswer1());
            stmt.setString(3, form.getAnswer2());
            stmt.setTimestamp(4, Timestamp.valueOf(form.getCreatedTime()));
            stmt.executeUpdate();
        }
    }

    public List<Form> getForms() throws SQLException {
        List<Form> forms = new ArrayList<>();
        String sql = "SELECT * FROM forms";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Form form = new Form(
                        rs.getString("pesel"),
                        rs.getString("answer1"),
                        rs.getString("answer2")
                );
                form.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                forms.add(form);
            }
        }
        return forms;
    }

    public boolean deleteForm(String pesel) throws SQLException {
        String sql = "DELETE FROM forms WHERE pesel = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pesel);
            return stmt.executeUpdate() > 0;
        }
    }
}