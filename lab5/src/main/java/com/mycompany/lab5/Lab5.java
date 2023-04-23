package com.mycompany.lab5;

import Commands.*;
import java.util.stream.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class Lab5 {
    public static void main(String args[]) throws InvalidCatalogException{
        Catalog catalog = new Catalog("My Catalog");
        catalog.add(new Document("1" , "doc1", "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5" ));
        catalog.add(new Document("2" , "doc2", "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5" ));
        catalog.add(new Document("3" , "doc3", "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5" ));

        Save catalog1= new Save();
        try{
            catalog1.save(catalog, "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5\\catalog.json");
        } catch (IOException ex){
            Logger.getLogger(Lab5.class.getName()).log(Level.SEVERE, null, ex);   
        }
        View view = new View();
        try {
            view.run("C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5\\catalog.json") ;
        } catch (IOException ex) {
            Logger.getLogger(Lab5.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        Report report = new Report ();
        //View catalogTwoV = new View();
        try {
            report.run(catalog) ;
        } catch (IOException ex) {
            Logger.getLogger(Lab5.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
