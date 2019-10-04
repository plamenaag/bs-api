package com.bookstore.api.dao;

import com.bookstore.api.dao.error.DaoObjectException;
import com.bookstore.api.model.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
public class ClientDao extends BaseDao {

    public List<Client> findAll(EntityManager em) {
        List<Client> result = Collections.emptyList();
        TypedQuery<Client> query = em.createNamedQuery("Client.findAll", Client.class);
        result = query.getResultList();
        return result;
    }

    public Client getById(EntityManager em, Integer id) {
        TypedQuery<Client> query = em.createNamedQuery("Client.findById", Client.class);
        query.setParameter("id", id);
        Client result = query.getSingleResult();
        return result;
    }

    public Client create(EntityManager em, Client entity) {
        em.persist(entity);
        return entity;
    }

    public Client update(EntityManager em, Client entity) throws Exception {
        if (entity.getId() != null) {
            entity = em.merge(entity);
        } else {
            throw new Exception("Primary key is invalid");
        }
        return entity;
    }

    public Client remove(EntityManager em, Integer id) throws DaoObjectException {
        Client entity = em.find(Client.class, id);
        em.remove(entity);
        return entity;

    }
}
