
package com.mycompany.lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public abstract class Albums implements genericDAO {
    public void create(int year, String name, String artist, String genre)  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (year,name,artist, genre) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, name);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into albums");
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void create(String name){
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String findAll() {
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "SELECT * FROM albums")){
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
        }   
        catch (SQLException ex) {
            Logger.getLogger(AlbumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException ex) {
            Logger.getLogger(AlbumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
