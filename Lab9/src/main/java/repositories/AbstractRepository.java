package repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.dom4j.tree.*;

import entities.PersistenceManager;
import jakarta.persistence.Persistence;
import javax.persistence.*;
/**
 *
 * @author Elias
 */
public abstract class AbstractRepository  <T extends AbstractEntity, ID extends Serializable> {
	private final EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory();
    private EntityManager em = entityManagerFactory.createEntityManager();


    public T findByName(String name) {
        return null;
    }
    
     public T findById(ID id) {
        return null;
    }
     public void persist(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

  
}
