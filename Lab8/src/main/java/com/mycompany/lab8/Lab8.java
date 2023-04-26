package com.mycompany.lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Elias
 */
public class Lab8 {

    public static void main(String args[]) throws SQLException {
        try {
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
            Connection con = Database.getConnection();

            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM albums";
            ResultSet rs = stmt.executeQuery(sql);
            
           
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("year");
                String title = rs.getString("name");
                String artist_name = rs.getString("artist");
                String genre = rs.getString("genre");
               
                System.out.println("ID: " + id);
                System.out.println("Release Year: " + releaseYear);
                System.out.println("Title: " + title);
                System.out.println("Artist ID: " + artist_name);
                System.out.println("Genre: " + genre);
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
