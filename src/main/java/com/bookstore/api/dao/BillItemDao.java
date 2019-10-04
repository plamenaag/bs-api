package com.bookstore.api.dao;

import com.bookstore.api.dao.error.DaoObjectException;
import com.bookstore.api.model.BillItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class BillItemDao extends BaseDao {


    public List<BillItem> findAll(EntityManager em) {
        List<BillItem> result = Collections.emptyList();
        TypedQuery<BillItem> query = em.createNamedQuery("BillItem.findAll", BillItem.class);
        result = query.getResultList();
        return result;
    }

    public BillItem getById(EntityManager em, Integer id) {
        TypedQuery<BillItem> query = em.createNamedQuery("Bill.findById", BillItem.class);
        query.setParameter("id", id);
        BillItem result = query.getSingleResult();
        return result;
    }

    public BillItem create(EntityManager em, BillItem entity) {
        em.persist(entity);
        return entity;
    }

    public BillItem update(EntityManager em, BillItem entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public BillItem remove(EntityManager em, Integer id) throws DaoObjectException {
        BillItem entity = em.find(BillItem.class, id);
        em.remove(entity);
        return entity;

    }
}
