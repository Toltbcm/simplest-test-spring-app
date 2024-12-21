package org.example.dao;

import org.example.model.EntityOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class EntityOneDaoImpl implements EntityOneDao {
    private final SessionFactory sessionFactory;

    public EntityOneDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EntityOne save(EntityOne entityOne) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entityOne);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save EntityOne: " + entityOne, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entityOne;
    }
}
