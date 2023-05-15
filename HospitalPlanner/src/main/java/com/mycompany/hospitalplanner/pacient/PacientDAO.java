package com.mycompany.hospitalplanner.pacient;

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
public class PacientDAO extends Pacient {

    public PacientDAO(String nume, String prenume, String data_nasterii, String adresa, String numar_telefon) {
        super(nume, prenume, data_nasterii, adresa, numar_telefon);
    }
    public void create()  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into pacients (nume,prenume,data_nasterii, adresa, numar_telefon) values (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setString(3, data_nasterii);
            pstmt.setString(4, adresa);
            pstmt.setString(5, numar_telefon);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into pacients");
        } catch (SQLException ex) {
            Logger.getLogger(Pacient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public int findId(){
        Connection con = Database.getConnection();
        ResultSet rs = null;
        int id =-1;
        try (PreparedStatement pstmt = con.prepareStatement(
                "select id from pacients where nume= ?")) {
            pstmt.setString(1, this.nume);
            rs = pstmt.executeQuery();
            if(rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pacient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }
}
