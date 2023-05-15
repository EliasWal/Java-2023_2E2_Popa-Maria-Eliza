package com.mycompany.hospitalplanner.programare;


/**
 *
 * @author Elias
 */
public abstract class Programare {
    String data;
    String ora;
    int id_pacient;
    int id_medic;
    int id_spital;

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
}
