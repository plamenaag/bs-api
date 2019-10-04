package com.bookstore.api.service;

import com.bookstore.api.Constants;
import com.bookstore.api.dao.BookDao;
import com.bookstore.api.model.Book;
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

//table book
//
///books -> get return all books;
///books/{bookId} - > get return book with id bookId (param id int)
///books -> post create book (param Book object)
///books/{bookId} - > put update book (params: id of book,Book object)
///books/{bookId} - delete delete book (param id of book)

@Path("/books")
@Stateless
@PermitAll
public class BookService {
    @Inject
    private BookDao bookDao;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public  List<Book> getAll(@Context SecurityContext securityContext) {
        List<Book> books = new ArrayList();
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            books = bookDao.findAll(em);
        }  catch (Exception ex) {
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return books;
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Book getById(@PathParam("id") Integer id, @Context HttpServletRequest request) {
        Book book = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            book = bookDao.getById(em, id);
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
        return book;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Book create(Book book, @Context SecurityContext securityContext) {
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            book.setFromDate(new Timestamp(System.currentTimeMillis()));
            book = bookDao.create(em, book);

            em.getTransaction().commit();

        } catch (Exception ex) {
            book = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Book update(@PathParam(Constants.PARAM_ID) Integer id, Book book,
                                      @Context SecurityContext securityContext) {

        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {

            em.getTransaction().begin();
            Book foundBook = bookDao.getById(em, id);
            if(foundBook!=null){
                   foundBook.setName(book.getName());
                   foundBook.setPrice(book.getPrice());
                   foundBook.setCount(book.getCount());
                  
            }
            book = bookDao.update(em, foundBook);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            book = null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Book delete(@PathParam(Constants.PARAM_ID) Integer id, @Context SecurityContext securityContext) {
        Book book = null;
        EntityManager em = EntityManagerFactoryUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            book = bookDao.remove(em, id);
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
        return book;
    }

}
