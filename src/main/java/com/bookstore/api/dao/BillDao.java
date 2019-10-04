package com.bookstore.api.dao;

import com.bookstore.api.dao.error.DaoObjectException;
import com.bookstore.api.model.Bill;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class BillDao extends BaseDao {

    public List<Bill> findAll(EntityManager em) {
        List<Bill> result = Collections.emptyList();
        TypedQuery<Bill> query = em.createNamedQuery("Bill.findAll", Bill.class);
        result = query.getResultList();
        return result;
    }

    public Bill getById(EntityManager em, Integer id) {
        TypedQuery<Bill> query = em.createNamedQuery("Bill.findById", Bill.class);
        query.setParameter("id", id);
        Bill result = query.getSingleResult();
        return result;
    }

    public Bill create(EntityManager em, Bill entity) {
        em.persist(entity);
        return entity;
    }

    public Bill update(EntityManager em, Bill entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public Bill remove(EntityManager em, Integer id) throws DaoObjectException {
        Bill entity = em.find(Bill.class, id);
        em.remove(entity);
        return entity;

    }
}
