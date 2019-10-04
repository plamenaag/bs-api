package com.bookstore.api;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationPath(value="/")
public class Application extends ResourceConfig {
    private final static Logger LOGGER;
    static {
            LOGGER = Logger.getLogger(ResourceConfig.class.getName());
            LOGGER.setLevel(Level.SEVERE);
    }

    public Application() {

        register(new ApplicationBinder());

        packages(true, "com.bookstore.api.service");
        register(MultiPartFeature.class);
        register(JacksonFeature.class);

    }
}
    