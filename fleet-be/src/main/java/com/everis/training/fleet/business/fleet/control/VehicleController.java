package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VehicleController {
    @Inject
    VehicleRepository vehicleRepository;

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);
    }

    public Vehicle retrieveVehicle(String vin) {
        return vehicleRepository.retrieveVehicle(vin);
    }

    public void removeVehicle(String vin) {
        vehicleRepository.removeVehicle(vin);
    }

    public List<Vehicle> retrieveAll() {
        return vehicleRepository.retrieveAll();
    }

    public List<Vehicle> retrieveUnreserved() {
        return vehicleRepository.retrieveUnreserved();
    }

    public void reserveVehicle(String vehicleVin, Integer customerId) {
        vehicleRepository.reserveVehicle(vehicleVin, customerId);
    }
}
