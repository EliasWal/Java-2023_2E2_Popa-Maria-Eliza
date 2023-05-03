package repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.dom4j.tree.*;

/**
 *
 * @author Elias
 */
public abstract class DataRepository  <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em ; //create it somehow

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
