/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalplanner.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Elias
 */
public class Database {
    private static final String URL
            = "jdbc:postgresql://localhost:5432/hospitalapp";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static Connection connection;

    private Database() {
        
    }

    
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
     

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }
    
     public static void closeConnection() throws SQLException { 
         connection.close();
    }
    public static void rollback() throws SQLException {
        connection.rollback();
    }

    public static void createTables() throws SQLException{
        connection = Database.getConnection();
        Statement stmt = connection.createStatement();
        try{
            String createPacientTable = "CREATE TABLE pacients ("
                        + "id SERIAL PRIMARY KEY,"
                        + "nume VARCHAR(50)"
                        + "prenume VARCHAR(50) "
                        + "data_nasterii Date"
                        + "adresa VARCHAR(100) "
                        + "numar_telefon VARCHAR(20)"
                        + ");";

            stmt.executeUpdate(createPacientTable);
            
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing statement/connection: " + e);
            }
        }
    }
    
}

