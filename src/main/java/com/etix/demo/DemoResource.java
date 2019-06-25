package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.TEXT_HTML)
@Path("/demo/")
public class DemoResource {

    @GET
    @Path("/hello/{name}")
    public Response hello(@PathParam("name") String name){
        if (name == null || name.length() == 0) {
            name = "demo";
        }
        return Response.ok("Hello, <b>" + name + "</b>").build();
    }
}
