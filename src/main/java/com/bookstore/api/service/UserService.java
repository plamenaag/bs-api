package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.UserDao;
import com.bookstore.api.model.User;
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

@Path("/users")
@Stateless
@PermitAll
public class UserService {

    @Inject
    private UserDao userDao;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getAll(@Context SecurityContext securityContext) {
        List<User> users = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            users = userDao.findAll(em);
        } catch (Exception ex) {
            Integer i = 0;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return users;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public User getById(@PathParam(Constants.PARAM_ID) Integer id, @Context HttpServletRequest request) {
        User user = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            user = userDao.getById(em, id);
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
        return user;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public User create(User user, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            user.setFromDate(new Timestamp(System.currentTimeMillis()));

            user = userDao.create(em, user);

            em.getTransaction().commit();

        } catch (Exception ex) {
            user = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return user;
    }

    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public User update(@PathParam(Constants.PARAM_ID) Integer id, User user,
            @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            User foundUser = userDao.getById(em, id);
            if (foundUser != null) {
                foundUser.setUsername(user.getUsername());
                foundUser.setPassword(user.getPassword());

            }
            user = userDao.update(em, foundUser);
            em.getTransaction().commit();

        } catch (Exception ex) {
            user = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return user;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) throws Exception {
        User user = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            user = userDao.remove(em, id);
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
        return user;
    }

}
