package com.mycompany.lab5;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elias
 */
public class CatalogUtil {
    
    ObjectMapper objectMapper = new ObjectMapper();
 
    public static void add(Catalog catalog, Document doc) {
        
        catalog.add(doc);
    }

    public String toString(Catalog catalog)
    {
        return catalog.toString() ;
    }

    public void save(Catalog catalog, String path) throws IOException {
         objectMapper.writeValue(new File(path), catalog);
    }
    
    public Catalog load(String path) throws IOException {
        Catalog value = objectMapper.readValue(new File(path), Catalog.class);
        return value ;
    }
}
