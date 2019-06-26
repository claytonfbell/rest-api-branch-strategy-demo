package com.etix.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

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

    @GET
    @Path("/currentTime")
    public Response currentTime() {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return Response.ok(nowAsISO).build();
    }
}
