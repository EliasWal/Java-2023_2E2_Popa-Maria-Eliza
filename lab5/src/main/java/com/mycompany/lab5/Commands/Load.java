package Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.lab5.Catalog;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Elias
 */
public class Load implements Generic{
    ObjectMapper objectMapper = new ObjectMapper();
    public Catalog load(String path) throws InvalidCatalogException{
        Catalog value;
        try{
            value=objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ex){
            throw new InvalidCatalogException( ex.toString () ) ;
        }
        return value;
    } 
}
