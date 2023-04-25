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
public class AlbumDAO {

    public void create(int year, String name, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into album (year,name,artist,genre) values (?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, name);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from album where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from album where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    
}
