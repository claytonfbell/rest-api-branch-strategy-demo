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
    @Produces(MediaType.APPLICATION_JSON)
    public Response currentTime() {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        CurrentTimeObject cto = new CurrentTimeObject();
        cto.setIs8601(nowAsISO);

        return Response.ok(cto).build();
    }
}

class CurrentTimeObject
{
    private String is8601;

    public String getIs8601() {
        return is8601;
    }

    public void setIs8601(String is8601) {
        this.is8601 = is8601;
    }
}