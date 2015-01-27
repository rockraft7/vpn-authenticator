package com.faizalsidek.vpn.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface AuthService {
    @GET
    @Path("/authenticate")
    @Produces("text/plain")
    Integer authenticate(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("serviceId") String serviceId);

    @GET
    @Path("/session/create")
    @Produces("text/plain")
    Integer createSession(@QueryParam("username") String username, @QueryParam("serviceId") String serviceId);

    @GET
    @Path("/session/invalidate")
    @Produces("text/plain")
    Integer invalidateSession(@QueryParam("username") String username, @QueryParam("serviceId") String serviceId);
}
