package com.faizalsidek.vpn.service;

import com.faizalsidek.vpn.entity.VpnService;
import com.faizalsidek.vpn.entity.VpnSession;
import com.faizalsidek.vpn.entity.VpnUser;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VpnInfoService {
    @GET
    @Path("/search/user/{username}")
    @Produces("application/json")
    VpnUser searchUser(@PathParam("username") String username);

    @GET
    @Path("/list/session")
    @Produces("application/json")
    List<VpnSession> listActiveSession();

    @GET
    @Path("/search/service")
    @Produces("application/json")
    List<VpnService> searchService(@QueryParam("serviceUrl") String serviceUrl, @QueryParam("serviceProtocol") String serviceProtocol);

    @GET
    @Path("/search/services")
    @Produces("application/json")
    List<VpnService> listServices();

    @POST
    @Path("/user/add")
    @Consumes("application/json")
    @Produces("text/plain")
    Integer addUser(VpnUser vpnUser);

    @GET
    @Path("/user/assign")
    @Consumes("application/json")
    @Produces("text/plain")
    Integer assignAuth(@QueryParam("username") String username, List<VpnService> vpnServices);

    @GET
    @Path("/user/disable")
    @Consumes("application/json")
    @Produces("text/plain")
    Integer disableUser(@QueryParam("username") String username, List<VpnService> vpnServices, @QueryParam("duration") String duration);

    @GET
    @Path("/user/enable")
    @Consumes("application/json")
    @Produces("text/plain")
    Integer enableUser(@QueryParam("username") String username, List<VpnService> vpnServices, @QueryParam("duration") String duration);
}
