package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.VehicleController;
import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/vehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class VehicleResource {
    @Inject
    VehicleController vehicleController;

    //CREATE
    @POST
    public Response addVehicle(Vehicle vehicle) {
        /*
            TODO Check that vehicle contains valid fields(17 char uniq vin, existing field fleet
             that belongs to existing fleet)
            and that registration was correctly performed (generate appropiate message if something
            went wrong
            return server error on db error case
        */
        vehicleController.addVehicle(vehicle);
        return Response.ok().entity("Vehicle added to the database.").build();
    }

    //RETRIEVE
    @Path("{vehicleVin}")
    @GET
    public Response retrieveVehicle(@PathParam("vehicleVin") String vehicleVin) {
        /*
            TODO Validation of parameter vin (17 char) and 404 if vehicle not found.
             return server error on db error case
         */
        Vehicle vehicle = vehicleController.retrieveVehicle(vehicleVin);
        return Response.ok().entity(vehicle).build();
    }
    //UPDATE
    //DELETE
    @Path("{vehicleVin}")
    @DELETE
    public Response removeVehicle(@PathParam("vehicleVin") String vin) {
        /*
            TODO Check vin 17 char, 404 if vehicle doesn't exist
            return server error on db error case
        */
        vehicleController.removeVehicle(vin);
        return Response.ok().entity("Vehicle removed from the database or doesn't exist.").build();
    }

    //Vehicle search (all/unreserved)
    @GET
    public Response search(@DefaultValue("false")@QueryParam("unreserved") String unreserved) {
        /*
            TODO return server error on db error case
         */
        if (unreserved.equals("true")) {
            return Response.ok().entity(vehicleController.retrieveUnreserved()).build();
        } else {
            return Response.ok().entity(vehicleController.retrieveAll()).build();
        }
    }

    //Vehicle reservation
    @Path("{vehicleVin}/reserve")
    @GET
    public Response reserve(@PathParam("vehicleVin") String vehicleVin,
                            @QueryParam("customerId") Integer customerId) {
        /*
            TODO check:
                - vin 17 chars, belongs to vehicle, not reserved
                - customer present, belongs to a customer, he doesn't have any reserve
                -  return server error on db error case
         */
        vehicleController.reserveVehicle(vehicleVin, customerId);
        return Response.ok().entity("Reservation performed or customer doesn't exist.").build();
    }
}
