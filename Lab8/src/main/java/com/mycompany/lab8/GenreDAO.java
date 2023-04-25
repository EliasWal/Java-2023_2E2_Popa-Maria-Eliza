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
public class GenreDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genre (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genre where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from genre where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    
}
