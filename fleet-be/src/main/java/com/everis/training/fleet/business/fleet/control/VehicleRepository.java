package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class VehicleRepository {
    @PersistenceContext(unitName = "fleet-personal")
    EntityManager entityManager;

    public void addVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public Vehicle retrieveVehicle(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public void removeVehicle(String vin) {
        Vehicle vehicleToRemove = retrieveVehicle(vin);
        entityManager.remove(vehicleToRemove);
    }

    public List<Vehicle> retrieveAll() {
        return entityManager.createNamedQuery("allVehicles").getResultList();
    }

    public List<Vehicle> retrieveUnreserved() {
        return entityManager.createNamedQuery("unreservedVehicles").getResultList();
    }

    public void reserveVehicle(String vehicleVin, Integer customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        customer.setVehicleVin(vehicleVin);
    }
}
