package com.mycompany.hospitalplanner.programare;

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
public class Programare {
    private String data, ora;
    private int id_pacient, id_medic, id_spital;

    public Programare(String data, String ora, int id_pacient, int id_medic, int id_spital) {
        this.data = data;
        this.ora = ora;
        this.id_pacient = id_pacient;
        this.id_medic = id_medic;
        this.id_spital = id_spital;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(int id_pacient) {
        this.id_pacient = id_pacient;
    }

    public int getId_medic() {
        return id_medic;
    }

    public void setId_medic(int id_medic) {
        this.id_medic = id_medic;
    }

    public int getId_spital() {
        return id_spital;
    }

    public void setId_spital(int id_spital) {
        this.id_spital = id_spital;
    }
    

    public void create()  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into programare (data,ora,id_pacient, adresa, numar_telefon) values (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setString(3, data_nasterii);
            pstmt.setString(4, adresa);
            pstmt.setString(5, numar_telefon);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into programare");
        } catch (SQLException ex) {
            Logger.getLogger(Programare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  //  String data, String ora, = int id_pacient, int id_medic, int id_spital) {
    
}
