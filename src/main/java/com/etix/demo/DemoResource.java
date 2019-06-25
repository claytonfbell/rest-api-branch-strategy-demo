package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo/")
public class DemoResource {

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("name") String name){
        return Response.ok("Hello, " + name).build();
    }
}
