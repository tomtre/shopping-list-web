package com.tomtre.shoppinglist.web.dao;

import com.tomtre.shoppinglist.web.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {


    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> query = getEM().createQuery("FROM Role r WHERE r.name = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }
}
