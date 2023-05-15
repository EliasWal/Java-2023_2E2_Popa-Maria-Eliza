package com.mycompany.hospitalplanner.medic;

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
public class MedicDAO extends Medic{

    public MedicDAO(String nume, String prenume, String specializare, String adresa, String numar_telefon) {
        super(nume, prenume, specializare, adresa, numar_telefon);
    }
    public void create()  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into medici (nume,prenume,specializare, adresa, numar_telefon) values (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setString(3, specializare);
            pstmt.setString(4, adresa);
            pstmt.setString(5, numar_telefon);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into medici");
        } catch (SQLException ex) {
            Logger.getLogger(Medic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int findId(){
        Connection con = Database.getConnection();
        ResultSet rs = null;
        int id =-1;
        try (PreparedStatement pstmt = con.prepareStatement(
                "select id from medici where nume= ? AND prenume =?")) {
            pstmt.setString(1, this.nume);
            pstmt.setString(2, this.prenume);
            rs = pstmt.executeQuery();
            if(rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }
}
