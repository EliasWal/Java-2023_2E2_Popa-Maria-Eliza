package repositories;

import entities.Album;
import entities.PersistenceManager;
import entities.Artist;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dom4j.tree.AbstractEntity;
/**
 *
 * @author Elias
 */
public class AlbumRepository extends AbstractRepository<Album, Integer>   {
    private EntityManagerFactory em = Persistence.createEntityManagerFactory("default");//.getEntityManagerFactory(); //create it somehow
    
    public Album findByArtist(Artist artist) {
        EntityManager entityManager = em.createEntityManager();
        return  (Album) entityManager.createNamedQuery("Album.findByArtist")
        .setParameter("artist", artist)
        .getResultList().get(0);
    }
    
    public Album findById(int id){
        EntityManager entityManager = em.createEntityManager();
        return (Album) entityManager.createNamedQuery("Album.findById")
                .setParameter("id", id)
                .getResultList().get(0);
    }
    public void create(Album album){
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
