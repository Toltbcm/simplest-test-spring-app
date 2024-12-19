package org.example.service;

import org.example.dao.EntityOneDao;
import org.example.model.EntityOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityOneServiceImpl implements EntityOneService {
    @Autowired
    private EntityOneDao entityOneDao;

    @Override
    public EntityOne save(EntityOne entityOne) {
        return entityOneDao.save(entityOne);
    }
}