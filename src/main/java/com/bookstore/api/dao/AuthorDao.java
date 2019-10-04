package com.bookstore.api.dao;

import com.bookstore.api.dao.error.DaoObjectException;
import com.bookstore.api.model.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class AuthorDao extends BaseDao {

    public List<Author> findAll(EntityManager em) {
        List<Author> result = Collections.emptyList();
        TypedQuery<Author> query = em.createNamedQuery("Author.findAll", Author.class);
        result = query.getResultList();
        return result;
    }

    public Author getById(EntityManager em, Integer id) {
        TypedQuery<Author> query = em.createNamedQuery("Author.findById", Author.class);
        query.setParameter("id", id);
        Author result = query.getSingleResult();
        return result;
    }

    public Author create(EntityManager em, Author entity) {
        em.persist(entity);
        return entity;
    }

    public Author update(EntityManager em, Author entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public Author remove(EntityManager em, Integer id) throws DaoObjectException {
        Author entity = em.find(Author.class, id);
        em.remove(entity);
        return entity;

    }
}
