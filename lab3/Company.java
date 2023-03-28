package lab3;
import java.util.*;

public class Company implements Node, Comparable<Company>  {
 
    String name;
    int startYear;
    int nrEmployee; 
    public void setName(String name) {
        this.name = name;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setNrEmployee(int nrEmployee) {
        this.nrEmployee = nrEmployee;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getNrEmployee() {
        return nrEmployee;
    }

    public Company(String name, int startYear, int nrEmployee) {
        this.name = name;
        this.startYear = startYear;
        this.nrEmployee = nrEmployee;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo ( Company other )
    {
        if(!(other instanceof Company))
            return -1;
        return this.name.compareTo(other.name);
    }

    
}
