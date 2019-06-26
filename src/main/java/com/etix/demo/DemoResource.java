package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Produces(MediaType.TEXT_HTML)
@Path("/demo")
public class DemoResource {

    @GET
    @Path("/hello/{name}/{from}")
    public Response hello(@PathParam("name") String name, @PathParam("from") String from){
        if (name == null || name.length() == 0) {
            name = "world";
        }
        return Response.ok("Hello, <b>" + name + "</b>. Now it is " + LocalDate.now() + "<br/> From: <b>" + from + "</b>").build();
    }
}
