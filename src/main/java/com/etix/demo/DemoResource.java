package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Date;

@Produces(MediaType.TEXT_HTML)
@Path("/demo/")
public class DemoResource {

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("name") String name){
        if (name == null || name.length() == 0) {
            name = "world";
        }
        return Response.ok("Hello, " + name + "! Now it is "+ LocalDate.now()).build();
    }
}
