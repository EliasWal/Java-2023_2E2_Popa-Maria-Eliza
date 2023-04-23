
package Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.lab5.Catalog;
import java.io.*;

/**
 *
 * @author Elias
 */
public class Save implements Generic{
    ObjectMapper objectMapper = new ObjectMapper();
    public void save(Catalog catalog, String path) throws IOException{
        objectMapper.writeValue(new File(path), catalog);
    } 
}
