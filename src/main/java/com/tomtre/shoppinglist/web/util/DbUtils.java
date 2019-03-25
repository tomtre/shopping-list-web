package com.tomtre.shoppinglist.web.util;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DbUtils {

    public static boolean checkIfValueExists(EntityManager em, Class<?> entityClass, String columnName, String value) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Object> cq = cb.createQuery();
        Root root = cq.from(entityClass);

        cq.select(root.get(columnName));
        cq.where(cb.equal(root.get(columnName), value));

        Query query = em.createQuery(cq);
        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}
