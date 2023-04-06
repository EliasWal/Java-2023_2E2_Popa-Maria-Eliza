package com.mycompany.lab5;
import java.util.stream.*;
import java.io.IOException;

/**
 *
 * @author Elias
 */
public class Lab5 {
    public static void main(String args[]) throws InvalidCatalogException{
        Lab5 app=new Lab5();
        app.testCreateSave();
        app.testLoadView();
    }
    
    private void testCreateSave() throws InvalidCatalogException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1","Hello world.txt","C:\\Users\\Elias\\Desktop" );
        var article = new Document("book1","Hello.txt", "C:\\Users\\Elias\\Desktop" );
        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog, "C:\\Users\\Elias\\Desktop\\catalog.json");
    }

    private void testLoadView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
