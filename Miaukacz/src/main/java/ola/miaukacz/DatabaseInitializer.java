/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.miaukacz;

import java.sql.*;

public class DatabaseInitializer {
    private static final String CREATE_TABLE_SQL = 
        "CREATE TABLE IF NOT EXISTS forms (" +
        "pesel VARCHAR(11) PRIMARY KEY, " +
        "answer1 VARCHAR(255), " +
        "answer2 VARCHAR(255), " +
        "created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";

    public static void initializeDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test_copy", "Misiek", "Groomer");
             Statement stmt = connection.createStatement()) {
            stmt.execute(CREATE_TABLE_SQL);
        }
    }
}
