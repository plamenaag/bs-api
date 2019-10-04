package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.ClientDao;
import com.bookstore.api.model.Client;
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

@Path("/clients")
@Stateless
@PermitAll
public class ClientService {
    @Inject
    private ClientDao clientDao;


    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public  List<Client> getAll(@Context SecurityContext securityContext) {
        List<Client> clients = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            clients = clientDao.findAll(em);
        }  catch (Exception ex) {
            Integer i = 0;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return clients;
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Client getById(@PathParam(Constants.PARAM_ID) Integer id, @Context HttpServletRequest request) {
        Client client = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            client = clientDao.getById(em, id);
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
        return client;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Client create(Client client, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            client.setFromDate(new Timestamp(System.currentTimeMillis()));

            client = clientDao.create(em, client);

            em.getTransaction().commit();

        } catch (Exception ex) {
            client = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return client;
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Client update(@PathParam(Constants.PARAM_ID) Integer id, Client client,
                                      @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            Client foundClient= clientDao.getById(em, id);
            if(foundClient!=null){
                   foundClient.setName(client.getName());
                   foundClient.setPhoneNumber(client.getPhoneNumber());
                  
            }
            client = clientDao.update(em, foundClient);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            client = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return client;
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Client delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) throws Exception {
        Client client = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            client = clientDao.remove(em, id);
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
        return client;
    }

}
