package com.mycompany.hospitalplanner.medic;

import com.mycompany.hospitalplanner.database.Database;
import com.mycompany.hospitalplanner.pacient.Pacient;
import com.mycompany.hospitalplanner.spital.Spital;
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
public class Medic {
    private String nume, prenume, specializare, adresa, numar_telefon;

    public Medic(String nume, String prenume, String specializare, String adresa, String numar_telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.adresa = adresa;
        this.numar_telefon = numar_telefon;
    }

    

    
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrTelefon() {
        return numar_telefon;
    }

    public void setNrTelefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
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
                "select id from medic where nume= ? AND prenume =?")) {
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
