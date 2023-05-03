package entities;

import javax.persistence.*;
/**
 *
 * @author Elias
 */
public class EntityManager {
    public static final boolean DEBUG = true;
    private static final EntityManager singleton = new EntityManager();

    protected EntityManagerFactory entityManagerFactory;

    public static EntityManager getInstance() {
        return singleton;
    }

    private EntityManager() {
    }

    protected void createEntityManagerFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");

        if (DEBUG) {
            System.out.println("Persistence started at " + new java.util.Date());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            createEntityManagerFactory();
        }
        return entityManagerFactory;
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;

            if (DEBUG) {
                System.out.println("Persistence finished at " + new java.util.Date());
            }
        }
    }
}
