package lab3;


public class Programmer extends Person{
    private String type;
    private String language;

    
    public Programmer(String name, String birthDate, String type, String language) {
        super(name, birthDate);
        this.type = type;
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLanguage(String language) {
        this.language = language;
    }   
    
}
