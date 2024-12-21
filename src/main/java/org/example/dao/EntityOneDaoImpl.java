package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.example.model.EntityOne;
import org.springframework.stereotype.Repository;

@Repository
public class EntityOneDaoImpl implements EntityOneDao {
    private final EntityManagerFactory entityManagerFactory;

    public EntityOneDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public EntityOne save(EntityOne entityOne) {
        EntityTransaction entityTransaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entityOne);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Can't save EntityOne: " + entityOne, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return entityOne;
    }
}
