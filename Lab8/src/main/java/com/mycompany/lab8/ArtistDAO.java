package com.mycompany.lab8;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class ArtistDAO extends Albums{

    @Override
    public void create(String name) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Integer findByName(String name)  {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException ex) {
            Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String findById(int id){
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from artists where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException ex) {
            Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
