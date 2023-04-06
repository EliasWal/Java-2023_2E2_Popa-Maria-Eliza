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
public class Catalog implements Serializable {

    private String name;
    private List<Document> docs = new ArrayList<> ();

    public Catalog(String name) {
        this.name = name;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog name: ").append(name).append("\n");
        for (Document document : docs) {
            sb.append(document.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void save(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), this);
    }
    
    public static Catalog load(String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ex) {
            throw new InvalidCatalogException(ex);
        }
    }
    
    
    
    

}
