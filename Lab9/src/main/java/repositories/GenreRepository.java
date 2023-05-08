
package repositories;

import entities.Genres;
import entities.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Elias
 */
public class GenreRepository {
    private static final EntityManagerFactory em = PersistenceManager.getInstance().getEntityManagerFactory();
    
    public void create(Genres genre) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public Genres findById(Integer id){
        EntityManager entityManager = em.createEntityManager();
        return (Genres) entityManager.createNamedQuery("Genres.findById").setParameter("id", id).getResultList().get(0);
    }
        
    public Genres findByName(String name){
        EntityManager entityManager = em.createEntityManager();
        return (Genres) entityManager.createNamedQuery("Genres.findByName").setParameter("name", name).getResultList().get(0);
    }
    
    public Genres findByAll(){
        EntityManager entityManager = em.createEntityManager();
        return (Genres) entityManager.createNamedQuery("Genres.findAll");
    }
    
}
