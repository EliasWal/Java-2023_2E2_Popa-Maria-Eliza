package Commands;

import com.mycompany.lab5.*;

/**
 *
 * @author Elias
 */
public class List {
    public void run(Catalog catalog){
        for (Document d: catalog.getDocs()){
            System.out.println(d);
        }
    }
}
