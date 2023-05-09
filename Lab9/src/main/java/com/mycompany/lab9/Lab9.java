package com.mycompany.lab9;

import entities.Album;
import entities.Artist;
import entities.PersistenceManager;
import javax.persistence.*;
import repositories.AlbumRepository;
import repositories.ArtistRepository;

/**
 *
 * @author Elias
 */
public class Lab9 {

    public static void main(String[] args) {
        
        ArtistRepository artistRepo = new ArtistRepository();
        
        System.out.println(artistRepo.findByName("Michael Jackson"));
        System.out.println(artistRepo.findById(3));
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        long startTime = System.currentTimeMillis();
        
        for(int i=1; i<=1000; i++) {
        	Artist artist = new Artist("Artist" + i);
        	em.persist(artist);
        	
        }
        
        long endTime = System.currentTimeMillis();
        transaction.commit();
        em.close();
        emf.close();
        
        long executionTime = endTime-startTime;
        System.out.println("Execution time " + executionTime + "ms");
       
       // System.out.println(artist.findByName(artist));
        
    }
}
