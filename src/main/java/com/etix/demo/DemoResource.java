package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Produces(MediaType.TEXT_HTML)
@Path("/demo")
public class DemoResource {

    @GET
    @Path("/hello/{name}")
    public Response hello(@PathParam("name") String name){
        if (name == null || name.length() == 0) {
            name = "world";
        }
        return Response.ok("Hello, <b>" + name + "</b>. Now it is " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))).build();
    }
}
