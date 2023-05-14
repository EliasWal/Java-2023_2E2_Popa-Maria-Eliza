package com.mycompany.hospitalplanner;

import com.mycompany.hospitalplanner.database.Database;
import com.mycompany.hospitalplanner.medic.Medic;
import com.mycompany.hospitalplanner.pacient.Pacient;
import com.mycompany.hospitalplanner.programare.Programare;
import com.mycompany.hospitalplanner.spital.Spital;
import java.sql.SQLException;

/**
 *
 * @author Elias
 */
public class HospitalPlanner {

    public static void main(String[] args) throws SQLException {
        Pacient pacient=new Pacient("Damian", "Andreea", "12/02/2002", "Iasi", "0768584993");
        
        //pacient.create();
        Medic medic = new Medic("Huma", "Darius", "Cardiologie", "Iasi, Jud. Iasi", "0076454554");
        //medic.create();
        
        Spital spital = new Spital("Spiridon", "Iasi", "Iasi", "Bld. Independentei 1");
        //spital.create();
        int idPacient = pacient.findId();
        int idSpital = spital.findId();
        int idMedic = medic.findId();
        System.out.println(idPacient + " " + idSpital + " " + idMedic);
        //Programare programare = new Programare ("15/05/2023", "12:00",idPacient, idMedic, idSpital );
        Database.getConnection().commit();
        Database.getConnection().close();
        
    }
}
