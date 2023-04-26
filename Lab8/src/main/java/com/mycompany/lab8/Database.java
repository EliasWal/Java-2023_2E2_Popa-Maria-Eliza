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
            connection.setAutoCommit(false);
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
            String createArtistsTable = "CREATE TABLE artists ("
                        + "id SERIAL PRIMARY KEY,"
                        + "name VARCHAR(255) NOT NULL"
                        + ");";
            stmt.executeUpdate(createArtistsTable);

            String createGenresTable = "CREATE TABLE genres ("
                        + "id SERIAL PRIMARY KEY,"
                        + "name VARCHAR(255) NOT NULL"
                        + ");";
            stmt.executeUpdate(createGenresTable);

            String createAlbumsTable = "CREATE TABLE albums ("
                        + "id SERIAL PRIMARY KEY,"
                        + "release_year INTEGER NOT NULL,"
                        + "title VARCHAR(255) NOT NULL,"
                        + "artist_id INTEGER NOT NULL,"
                        + "FOREIGN KEY (artist_id) REFERENCES artists (id)"
                        + ");";
            stmt.executeUpdate(createGenresTable); 

             String createAlbumGenresTable = "CREATE TABLE album_genres ("
                        + "album_id INTEGER NOT NULL,"
                        + "genre_id INTEGER NOT NULL,"
                        + "PRIMARY KEY (album_id, genre_id),"
                        + "FOREIGN KEY (album_id) REFERENCES albums (id),"
                        + "FOREIGN KEY (genre_id) REFERENCES genres (id)"
                        + ");";
            stmt.executeUpdate(createAlbumGenresTable);
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
