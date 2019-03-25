package com.tomtre.shoppinglist.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao {

    @PersistenceContext
    private EntityManager entityManager;


    protected EntityManager getEM() {
        return entityManager;
    }
}
