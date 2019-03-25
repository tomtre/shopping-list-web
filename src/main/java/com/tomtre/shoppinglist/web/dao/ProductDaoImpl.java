package com.tomtre.shoppinglist.web.dao;

import com.tomtre.shoppinglist.web.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public List<Product> findOrderByCreateDateTime(long userId) {
        TypedQuery<Product> query = getEM().createQuery("FROM Product p WHERE p.user.id = :userId ORDER BY p.createDateTime", Product.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public Optional<Product> find(long productId, long userId) {
        TypedQuery<Product> query = getEM().createQuery("FROM Product p WHERE p.id = :productId AND p.user.id = :userId", Product.class);
        query.setParameter("productId", productId);
        query.setParameter("userId", userId);
        return query.getResultStream().findFirst();
    }

    @Override
    public void remove(long productId, long userId) {
        Query query = getEM().createQuery("DELETE FROM Product p WHERE p.id = :productId AND p.user.id = :userId");
        query.setParameter("productId", productId);
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public Product save(Product product) {
        getEM().persist(product);
        return product;
    }

    @Override
    public void update(Product product) {
        getEM().merge(product);
    }

    @Override
    public void mark(long productId, long userId) {
        Query query = getEM().createQuery("UPDATE Product p SET p.marked = true WHERE p.id = :productId AND p.user.id = :userId");
        query.setParameter("productId", productId);
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public void unmark(long productId, long userId) {
        Query query = getEM().createQuery("UPDATE Product p SET p.marked = false WHERE p.id = :productId AND p.user.id = :userId");
        query.setParameter("productId", productId);
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

}
