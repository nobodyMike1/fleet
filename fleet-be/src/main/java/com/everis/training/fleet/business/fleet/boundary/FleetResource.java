package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.FleetController;
import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/fleets")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FleetResource {

    @Inject
    FleetController fleetController;

    // CREATE
    @POST
    public Response addFleet(Fleet fleet) {
        /*
            TODO
                - Check if fleet is valid (id not null, not present in db)
                - return server error MSG on db error case
        */
        fleetController.addFleet(fleet);
        return Response.ok().entity("Fleet added to the database.").build();
    }

    //RETRIEVE
    @Path("{fleetId}")
    @GET
    public Response retrieveFleet(@PathParam("fleetId") int fleetId) {
        /*
            TODO
                - 404 if fleet not existing
                - return server error MSG on db error case
        */
        return Response.ok().entity(fleetController.retrieveFleet(fleetId)).build();
    }
    // UPDATE Not implemented
    // DELETE
    @Path("{fleetId}")
    @DELETE
    public Response removeFleet(@PathParam("fleetId") int fleetId) {
        /*
            TODO
                - check if fleet corresponds to an existing fleet
                - return server error MSG on db error case
        */
        fleetController.removeFleet(fleetId);
        return Response.ok().entity("Fleet removed from the database.").build();
    }

    // RETRIEVE ALL
    @GET
    public Response retrieveAll() {
        /*
            TODO
                - return server error MSG on db error case
        */
        return Response.ok().entity(fleetController.retrieveAll()).build();
    }
}
