package Commands;

import com.mycompany.lab5.Catalog;

/**
 *
 * @author Elias
 */
public class toString implements Generic{
    public String run(Catalog catalog){
        return catalog.toString();
    }
}
