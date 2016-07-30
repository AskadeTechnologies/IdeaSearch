package com.askade.ideallq.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("resources")
public class IdeallQRestResource {
    public IdeallQRestResource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = { "application/json", "application/xml" })
    @Path("login")
    public Response createCustomer(InputStream incomingData) {
        StringBuilder receivedData = new StringBuilder();
        Response.ResponseBuilder response = null;
        response = Response.status(401).type(MediaType.TEXT_HTML).entity("ok");
        return response.build();
    }
}
