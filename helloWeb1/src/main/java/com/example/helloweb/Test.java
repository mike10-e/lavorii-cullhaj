package com.example.helloweb;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class Test {

    @GET
    @Path("{name}")
    public String test(@PathParam("name") String name) {
        return "Ciao " + name.toUpperCase();
    }
}
