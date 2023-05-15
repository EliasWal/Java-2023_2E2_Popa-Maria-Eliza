package com.mycompany.hospitalplanner;

import com.mycompany.hospitalplanner.database.Database;
import com.mycompany.hospitalplanner.*;
import com.mycompany.hospitalplanner.GUI.Login;
import com.mycompany.hospitalplanner.GUI.Register;
import com.mycompany.hospitalplanner.GUI.Welcome;
import com.mycompany.hospitalplanner.medic.MedicDAO;
import com.mycompany.hospitalplanner.pacient.Pacient;
import com.mycompany.hospitalplanner.pacient.PacientDAO;
import com.mycompany.hospitalplanner.programare.ProgramareDAO;
import com.mycompany.hospitalplanner.spital.Spital;
import com.mycompany.hospitalplanner.spital.SpitalDAO;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author Elias
 */
public class HospitalPlanner {

    public static void main(String[] args) throws SQLException {
        var pacient=new PacientDAO("Damian", "Andreea", "12/02/2002", "Iasi", "0768584993");
        //pacient.create();
        
        var medic = new MedicDAO("Huma", "Darius", "Cardiologie", "Iasi, Jud. Iasi", "0076454554");
        //medic.create();
        
        var spital = new SpitalDAO("Spiridon", "Iasi", "Iasi", "Bld. Independentei 1");
        //spital.create();
        
        int idPacient = pacient.findId();
        int idSpital = spital.findId();
        int idMedic = medic.findId();
        
        var programare = new ProgramareDAO ("15/05/2023", "12:00",idPacient, idMedic, idSpital );
        //programare.create();
        Login login=new Login();
        //login.setVisible(true);
        Register register=new Register();
        //register.setVisible(true);
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
        
        Database.getConnection().commit();
        Database.getConnection().close();
        
    }
}
