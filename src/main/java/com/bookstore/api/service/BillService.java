package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.BillDao;
import com.bookstore.api.model.Bill;
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

@Path("/bills")
@Stateless
@PermitAll
public class BillService {

    @Inject
    private BillDao billDao;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bill> getAll(@Context SecurityContext securityContext) {
        List<Bill> bills = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            bills = billDao.findAll(em);
        } catch (Exception ex) {
            Integer i = 0;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return bills;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Bill getById(@PathParam(Constants.PARAM_ID) Integer id, @Context HttpServletRequest request) {
        Bill bill = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            bill = billDao.getById(em, id);
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
        return bill;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Bill create(Bill bill, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            bill.setFromDate(new Timestamp(System.currentTimeMillis()));

            bill = billDao.create(em, bill);

            em.getTransaction().commit();

        } catch (Exception ex) {
            bill = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return bill;
    }

    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Bill update(@PathParam(Constants.PARAM_ID) Integer id, Bill bill,
            @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            Bill foundBill = billDao.getById(em, id);
            if (foundBill != null) {
                foundBill.setTotal(bill.getTotal());
                foundBill.setClient(bill.getClient());
                foundBill.setUser(bill.getUser());

            }
            bill = billDao.update(em, foundBill);
            em.getTransaction().commit();

        } catch (Exception ex) {
            bill = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return bill;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bill delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) throws Exception {
        Bill bill = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            bill = billDao.remove(em, id);
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
        return bill;
    }

}
