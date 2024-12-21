package org.example.service;

import org.example.dao.EntityOneDao;
import org.example.model.EntityOne;
import org.springframework.stereotype.Service;

@Service
public class EntityOneServiceImpl implements EntityOneService {
    private final EntityOneDao entityOneDao;

    public EntityOneServiceImpl(EntityOneDao entityOneDao) {
        this.entityOneDao = entityOneDao;
    }

    @Override
    public EntityOne save(EntityOne entityOne) {
        return entityOneDao.save(entityOne);
    }
}
