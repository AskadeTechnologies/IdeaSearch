package com.askade.ideallq.resources;

import com.askade.ideallq.model.nlp.NLPSearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import javax.json.JsonObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.xml.stream.XMLStreamException;


@Path("resourcesideallq")
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchItems")
    public NLPBean getSearchItems(JsonObject inputJSONObj) {
        
        String input = inputJSONObj.getString("text");
        Set<String> myResponse = new HashSet<String>();
    
        try {
            myResponse = NLPSearch.getSearchItemsRemap(input);
        } catch (Exception e) {
            System.out.println("NLP Module Exception"+e);
            myResponse.add("NLP parsing failed");
     } 
            
            return new NLPBean(myResponse);
        
    }
    
    
}
