/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalplanner.spital;

import com.mycompany.hospitalplanner.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class SpitalDAO extends Spital {

    public SpitalDAO(String nume, String judet, String oras, String adresa) {
        super(nume, judet, oras, adresa);
    }
    public void create()  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into spitale (nume, judet, oras, adresa) values (?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, judet);
            pstmt.setString(3, oras);
            pstmt.setString(4, adresa);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into spitale");
        } catch (SQLException ex) {
            Logger.getLogger(Spital.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int findId(){
        Connection con = Database.getConnection();
        ResultSet rs = null;
        int id =-1;
        try (PreparedStatement pstmt = con.prepareStatement(
                "select id from spitale where nume= ?")) {
            pstmt.setString(1, this.nume);
            rs = pstmt.executeQuery();
            if(rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Spital.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }
}
