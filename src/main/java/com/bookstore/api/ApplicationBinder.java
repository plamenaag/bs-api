package com.bookstore.api;

import com.bookstore.api.dao.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(BookDao.class).to(BookDao.class);
        bind(AuthorDao.class).to(AuthorDao.class);
        bind(ClientDao.class).to(ClientDao.class);
        bind(BillDao.class).to(BillDao.class);
        bind(UserDao.class).to(UserDao.class);
        bind(BillItemDao.class).to(BillItemDao.class);
    }
    
}
