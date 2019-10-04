package com.bookstore.api.service;

import com.bookstore.api.dto.ServiceResponse;
import com.bookstore.api.dto.ServiceResponse.Status;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Stateless
@PermitAll
public class TestService {
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public String getHelloWorld(@QueryParam("name") String name, @Context HttpServletRequest request) {
           return "Hello " + name;
    }
    
    @GET
    @Path("/ok")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public ServiceResponse getOk(@Context HttpServletRequest request) {
        ServiceResponse response = new ServiceResponse(Status.SUCCESS);
        try {
            response.setData("OK");
        } catch (Exception ex) {
            response.setStatusCode(Status.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }


    
}
