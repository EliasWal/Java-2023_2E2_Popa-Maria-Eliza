package com.mycompany.hospitalplanner.pacient;

import com.mycompany.hospitalplanner.database.Database;
import com.mycompany.hospitalplanner.database.DatabaseConnectionManager;
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

    private String password;

    public PacientDAO(String nume, String prenume, char[] password, String data_nasterii, String adresa, String numar_telefon) {
        super(nume, prenume, data_nasterii, adresa, numar_telefon);
    }

    /**
     *
     */
    
    public void create()  {
        try (Connection con = DatabaseConnectionManager.getDataSource().getConnection(); PreparedStatement pstmt = con.prepareStatement(
                "insert into pacients (nume, prenume, password, data_nasterii, adresa, numar_telefon) values (?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setString(3, password);
            pstmt.setString(4, data_nasterii);
            pstmt.setString(5, adresa);
            pstmt.setString(6, numar_telefon);
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
                "select id from pacients where nume= ? and password = ?")) {
            pstmt.setString(1, this.nume);
            pstmt.setString(2, this.password);
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
