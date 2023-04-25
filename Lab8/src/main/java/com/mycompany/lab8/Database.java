package com.mycompany.lab8;

import java.sql.*;

/**
 *
 * @author Elias
 */
public class Database {
    private static final String URL
            = "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {
        return connection;
    }
     

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }
    
     public static void closeConnection() throws SQLException { 
         connection.close();
    }

    
}
