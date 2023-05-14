package com.mycompany.hospitalplanner.spital;

import com.mycompany.hospitalplanner.database.Database;
import com.mycompany.hospitalplanner.pacient.Pacient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class Spital {
    private String nume, judet, oras, adresa;

    public Spital(String nume, String judet, String oras, String adresa) {
        this.nume = nume;
        this.judet = judet;
        this.oras = oras;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
}
