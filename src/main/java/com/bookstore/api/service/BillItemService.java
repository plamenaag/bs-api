package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.BillItemDao;
import com.bookstore.api.model.BillItem;
import com.bookstore.api.utils.EntityManagerFactoryUtil;
import java.sql.Timestamp;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("/billItems")
@Stateless
@PermitAll
public class BillItemService {

    @Inject
    private BillItemDao billItemDao;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<BillItem> getAll(@Context SecurityContext securityContext) {
        List<BillItem> billItems = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            billItems = billItemDao.findAll(em);
        } catch (Exception ex) {
            Integer i = 0;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return billItems;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public BillItem getById(@PathParam(Constants.PARAM_ID) Integer id, @Context HttpServletRequest request) {
        BillItem billItem = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            billItem = billItemDao.getById(em, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return billItem;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public BillItem create(BillItem billItem, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            billItem.setFromDate(new Timestamp(System.currentTimeMillis()));

            billItem = billItemDao.create(em, billItem);

            em.getTransaction().commit();

        } catch (Exception ex) {
            billItem = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return billItem;
    }

    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public BillItem update(@PathParam(Constants.PARAM_ID) Integer id, BillItem billItem,
            @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            BillItem foundBillItem = billItemDao.getById(em, id);
            if (foundBillItem != null) {
                foundBillItem.setName(billItem.getName());
                foundBillItem.setPrice(billItem.getPrice());
                foundBillItem.setCount(billItem.getCount());
                foundBillItem.setBook(billItem.getBook());
                foundBillItem.setBill(billItem.getBill());

            }
            billItem = billItemDao.update(em, foundBillItem);
            em.getTransaction().commit();

        } catch (Exception ex) {
            billItem = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return billItem;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public BillItem delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) throws Exception {
        BillItem billItem = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            billItem = billItemDao.remove(em, id);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return billItem;
    }

}
