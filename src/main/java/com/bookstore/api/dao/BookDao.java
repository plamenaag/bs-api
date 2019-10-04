package com.bookstore.api.dao;

import com.bookstore.api.model.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class BookDao extends BaseDao {

    public List<Book> findAll(EntityManager em) {
        List<Book> result = Collections.emptyList();
        TypedQuery<Book> query = em.createNamedQuery("Book.findAll", Book.class);
        result = query.getResultList();
        return result;
    }

    public Book getById(EntityManager em, Integer id) {
        TypedQuery<Book> query = em.createNamedQuery("Book.findById", Book.class);
        query.setParameter("id", id);
        Book result = query.getSingleResult();;
        return result;
    }

    public Book create(EntityManager em, Book entity) {
        em.persist(entity);
        return entity;
    }

    public Book update(EntityManager em, Book entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public Book remove(EntityManager em, Integer id) {
        Book entity = em.find(Book.class, id);
        em.remove(entity);
        return entity;

    }
}
