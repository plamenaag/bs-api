package com.bookstore.api.dao;

import com.bookstore.api.dao.error.DaoObjectException;
import com.bookstore.api.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class UserDao extends BaseDao {

    public List<User> findAll(EntityManager em) {
        List<User> result = Collections.emptyList();
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        result = query.getResultList();
        return result;
    }

    public User getById(EntityManager em, Integer id) {
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        User result = query.getSingleResult();
        return result;
    }

    public User create(EntityManager em, User entity) {
        em.persist(entity);
        return entity;
    }

    public User update(EntityManager em, User entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public User remove(EntityManager em, Integer id) throws DaoObjectException {
        User entity = em.find(User.class, id);
        em.remove(entity);
        return entity;

    }
}
