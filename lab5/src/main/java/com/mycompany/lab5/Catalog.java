package com.mycompany.lab5;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

/**
 *
 * @author Elias
 */
public class Catalog{

    private String name;
    private List<Document> docs = new ArrayList<> ();

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
    public void add(Document doc){
        docs.add(doc);
    }
    
    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Document> getDocs() {
        return docs;
    }

    @Override
    public String toString() {
        return "Catalog" + " name=" + name + ", docs=" + docs;
    }


}
