package com.tomtre.shoppinglist.web.dao;

import com.tomtre.shoppinglist.web.entity.User;
import com.tomtre.shoppinglist.web.util.DbUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public boolean checkIfUsernameExists(String username) {
        return DbUtils.checkIfValueExists(getEM(), User.class, User.USER_NAME_COLUMN_NAME, username);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return DbUtils.checkIfValueExists(getEM(), User.class, User.EMAIL_COLUMN_NAME, email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = getEM().createQuery("FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional<User> findWithRolesByUsername(String username) {
        TypedQuery<User> query = getEM().createQuery("FROM User u JOIN FETCH u.roles r WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional<User> findByUserId(long userId) {
        User user = getEM().find(User.class, userId);
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user) {
        getEM().merge(user);
    }

    @Override
    public void remove(long userId) {
        Query query = getEM().createQuery("DELETE FROM Product p WHERE p.user.id = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();

        query = getEM().createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }


    @Override
    public User save(User user) {
        getEM().persist(user);
        return user;
    }


}
