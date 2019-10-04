package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.AuthorDao;
import com.bookstore.api.model.Author;
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

@Path("/authors")
@Stateless
@PermitAll
public class AuthorService {
    @Inject
    private AuthorDao authorDao;


    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public  List<Author> getAll(@Context SecurityContext securityContext) {
        List<Author> authors = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            authors = authorDao.findAll(em);
        }  catch (Exception ex) {
            Integer i = 0;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return authors;
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Author getById(@PathParam(Constants.PARAM_ID) Integer id, @Context HttpServletRequest request) {
        Author author = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            author = authorDao.getById(em, id);
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
        return author;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Author create(Author author, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            author.setFromDate(new Timestamp(System.currentTimeMillis()));

            author = authorDao.create(em, author);

            em.getTransaction().commit();

        } catch (Exception ex) {
            author = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return author;
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Author update(@PathParam(Constants.PARAM_ID) Integer id, Author author,
                                      @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            Author foundAuthor = authorDao.getById(em, id);
            if(foundAuthor!=null){
                   foundAuthor.setName(author.getName());
                   foundAuthor.setEgn(author.getEgn());
                  
            }
            author = authorDao.update(em, foundAuthor);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            author = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return author;
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Author delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) throws Exception {
        Author author = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            author = authorDao.remove(em, id);
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
        return author;
    }

}
