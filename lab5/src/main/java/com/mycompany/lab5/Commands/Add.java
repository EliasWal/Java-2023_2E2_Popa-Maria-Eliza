package Commands;

import com.mycompany.lab5.*;

/**
 *
 * @author Elias
 */
public class Add implements Generic{
    void run(Catalog catalog, Document doc) throws InvalidCatalogException{
        if(catalog.getDocs().contains(doc))
            throw new InvalidCatalogException("This file already exists in the catalog!");
        catalog.add(doc);
    }
            
}
