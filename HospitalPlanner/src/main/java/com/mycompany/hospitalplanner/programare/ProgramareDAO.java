package com.mycompany.hospitalplanner.programare;

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
public class ProgramareDAO extends Programare {

    public ProgramareDAO(String data, String ora, int id_pacient, int id_medic, int id_spital) {
        super(data, ora, id_pacient, id_medic, id_spital);
    }
    public void create()  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into programare (data, ora, id_pacient, id_medic, id_spital ) values (?, ?, ?, ?, ?)")) {
            pstmt.setString(1,data);
            pstmt.setString(2, ora);
            pstmt.setInt(3, id_pacient);
            pstmt.setInt(4, id_medic);
            pstmt.setInt(5, id_spital);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully into programare");
        } catch (SQLException ex) {
            Logger.getLogger(Programare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
