/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.translator.resources;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String JDBC_URL = "jdbc:h2:~/test_translator";
    private static final String USER = "Misiek";
    private static final String PASSWORD = "Groomer";

    private static final String CREATE_OPERATIONS_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS operations (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "pl VARCHAR(20) NOT NULL, " +   // Zmiana na DOUBLE
                    "eng VARCHAR(20) NULL, " +   // Zmiana na DOUBLE
                    "de VARCHAR(50) NULL, " +  // Zmiana na DOUBLE
                    "timestamp TIMESTAMP NOT NULL" +
                    ");";

    public static void initializeDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = connection.createStatement()) {
            stmt.execute(CREATE_OPERATIONS_TABLE_SQL);
            //stmt.execute("DROP TABLE operations");
        }
    }
}

