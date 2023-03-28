package lab3;
import java.util.*; 

public class Designer extends Person{
    private String type;
    private String technology;
    public Designer(String name, String birthDate, String type, String technology){
        super( name, birthDate);
        this.type= type;
        this.technology= technology;    
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getType() {
        return type;
    }

    public String getTechnology() {
        return technology;
    }
    
}
