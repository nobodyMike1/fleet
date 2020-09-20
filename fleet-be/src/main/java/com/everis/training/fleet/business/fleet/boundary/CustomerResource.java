package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.CustomerController;
import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CustomerResource {
    @Inject
    CustomerController customerController;

    // CREATE
    @POST
    public Response addCustomer(Customer customer) {
        /*
            TODO
                - check customer is valid (id not present in db/customer not null)
                - return server error on db error case
         */
        customerController.addCustomer(customer);
        return Response.ok().entity("Customer added to the database.").build();
    }
    // RETRIEVE
    @Path("{customerId}")
    @GET
    public Response retrieveCustomer(@PathParam("customerId") int id) {
        /*
             TODO return server error msg on db error case
         */
        return Response.ok().entity(customerController.retrieveCustomer(id)).build();
    }

    // UPDATE
    // DELETE
    @Path("{customerId}")
    @DELETE
    public Response removeCustomer(@PathParam("customerId") int id) {
        /*
            TODO
                - check id belongs to a customer
                - return server error msg on db error case
         */
        customerController.removeCustomer(id);
        return Response.ok().entity("Customer removed from the database or it doesn't exist.").build();
    }
    // RETRIEVE ALL
    @GET
    public Response retrieveAll() {
        /*
            TODO return server error msg on db error case
         */
        return Response.ok().entity(customerController.retrieveAll()).build();
    }

    //FINISH RESERVATION
    @Path("{customerId}/finish-reservation")
    @GET
    public Response finishReservation(@PathParam("customerId") int customerId) {
        /*
            TODO
                - Check id belongs to customer and he has a reservation
                - return server error msg on db error case
         */
        customerController.finishReservation(customerId);
        return Response.ok().entity("Reservation finished successfully.").build();
    }
}
