package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository fleetRepository;

    /*
        TODO Error control for CRD.
    */
    public Fleet retrieveFleet(int  id) {
        return fleetRepository.retrieveFleet(id);
    }

    public void addFleet(Fleet fleet) {
        fleetRepository.addFleet(fleet);
    }

    public void removeFleet(int fleetId) {
       fleetRepository.removeFleet(fleetId);
    }

    public List<Fleet> retrieveAll() {
        return fleetRepository.retrieveAll();
    }
}
