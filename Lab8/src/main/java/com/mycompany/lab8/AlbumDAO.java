package com.mycompany.lab8;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class AlbumDAO extends Albums {
    
    @Override
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

    @Override
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

    @Override
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

    
    
    

    
}
