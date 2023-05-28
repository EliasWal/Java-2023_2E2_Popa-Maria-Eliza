package com.mycompany.hospitalplanner.pacient;

import com.mycompany.hospitalplanner.database.Database;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public abstract class Pacient {

    String nume;
    String prenume;
    String data_nasterii;
    String adresa;
    String numar_telefon;

    public Pacient(String nume, String prenume, String data_nasterii, String adresa, String numar_telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.adresa = adresa;
        this.numar_telefon = numar_telefon;
    }

    public Pacient() {
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
       
}


