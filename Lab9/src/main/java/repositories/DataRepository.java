package repositories;

import entities.AbstractEntity;
import java.io.Serializable;
import javax.persistence.EntityManager;

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
            beginTransaction();
            em.persist(entity);
            commit();
            em.close();
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }
}
