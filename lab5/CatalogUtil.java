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
    
    private static final Scanner scanner = new Scanner(System.in);
 
    public static void addDocument(Catalog catalog) {
        
        System.out.println("Enter document id: ");
        String id = scanner.nextLine();

        System.out.println("Enter document name: ");
        String name = scanner.nextLine();

        System.out.println("Enter document location (path or URL): ");
        String location = scanner.nextLine();

        Document document = new Document(id, name, location);

        System.out.println("Enter tag name (press enter to skip): ");
        String tagName = scanner.nextLine();
        while (tagName.isEmpty()) {
            System.out.println("Enter tag value: ");
            String tagValue = scanner.nextLine();
            document.addTag(tagName, tagValue);

            System.out.println("Enter tag name (press enter to skip): ");
            tagName = scanner.nextLine();
        }

        catalog.add(document);
    }
    
    public static void viewCatalog(Catalog catalog) {
        for (Document document : catalog.getDocs()) {
            System.out.println(document.toString());
        }
    }
    
    
    
    

    public static void save(Catalog catalog, String path) throws InvalidCatalogException {
         try {
             ObjectMapper objectMapper = new ObjectMapper();
             objectMapper.writeValue( new File(path),catalog);
         } catch (IOException ex) {
             Logger.getLogger(CatalogUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        public static Catalog load(String path) throws InvalidCatalogException {
         try {
             ObjectMapper objectMapper = new ObjectMapper();
             Catalog catalog = objectMapper.readValue( new File(path), Catalog.class);
             return null;
         } catch (IOException ex) {
             Logger.getLogger(CatalogUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
        }
}
