
package repositories;

import entities.Artist;
import entities.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Elias
 */
public class ArtistRepository {
        private EntityManagerFactory em = PersistenceManager.getInstance().getEntityManagerFactory(); //create it somehow
        
        public void create(ArtistRepository artist){
            EntityManager entityManager = em.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(artist);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        
        public  Artist findByName(String name){
            EntityManager entityManager = em.createEntityManager();
            return (Artist) entityManager.createNamedQuery("Artist.findByName").setParameter("name", name).getResultList().get(0);
        }
        
        public  Artist findById(Integer id){
            EntityManager entityManager = em.createEntityManager();
            return (Artist) entityManager.createNamedQuery("Artist.findById").setParameter("id", id).getResultList().get(0);
        }
        
        public Artist findAll(){
            EntityManager entityManager = em.createEntityManager();
            return (Artist) entityManager.createNamedQuery("Artist.findAll").getResultList();
        }
}
