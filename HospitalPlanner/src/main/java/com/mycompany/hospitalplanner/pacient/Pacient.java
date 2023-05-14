package com.mycompany.hospitalplanner.pacient;

import com.mycompany.hospitalplanner.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class Pacient {
    private String nume, prenume, data_nasterii, adresa, numar_telefon;

    public Pacient(String nume, String prenume, String data_nasterii, String adresa, String numar_telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
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

    public String getDataNasterii() {
        return data_nasterii;
    }

    public void setDataNasterii(String data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumarTelefon() {
        return numar_telefon;
    }

    public void setNumarTelefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
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
    
}

