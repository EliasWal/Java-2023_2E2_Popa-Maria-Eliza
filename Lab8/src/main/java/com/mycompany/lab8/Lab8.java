package com.mycompany.lab8;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Elias
 */
public class Lab8 {

    public static void main(String args[]) throws SQLException {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource("albums");

            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            System.out.println(artists.findByName("Michael Jackson"));
            System.out.println(artists.findById(4));
            
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();
            System.out.println(genres.findById(1));
            System.out.println(genres.findByName("Funk"));
            var albums = new AlbumDAO();
            //albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            System.out.println(albums.findByName("The Wall"));
            System.out.println(albums.findById(4));
            Database.getConnection().commit();
            
            albums.findAll();
            try{
            Dataset dataset = new Dataset("albumlist.csv");
            } catch (IOException e) {
                System.err.println("Error reading dataset: " + e.getMessage());
            }
        albums.findAll();
            Database.getConnection().close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
