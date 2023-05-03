package com.mycompany.lab9;

import entities.Artist;
import javax.persistence.*;

/**
 *
 * @author Elias
 */
public class Lab9 {

    public static void main(String[] args) {
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        em.persist(artist);

        Artist a = (Artist)em.createQuery(
        "select e from Artist e where e.name='Beatles'")
        .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
