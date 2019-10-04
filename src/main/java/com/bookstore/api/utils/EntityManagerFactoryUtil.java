package com.bookstore.api.utils;

import com.bookstore.api.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Singleton
public final class EntityManagerFactoryUtil {
    private static EntityManagerFactory emf;
	
    private final static Logger LOGGER;

	static {
		LOGGER = Logger.getLogger(EntityManagerFactoryUtil.class.getName());

		LOGGER.setLevel(Level.SEVERE);
	}
    
	public static EntityManagerFactory getInstance() {
        if (emf == null) {
            try {
                emf = Persistence
                .createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
            } catch (Throwable t) {
                LOGGER.log(Level.ALL, "Failure during static initialization {0}", t);
                throw t;
            }
        }
		return emf;
	}
}
