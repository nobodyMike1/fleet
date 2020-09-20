package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class FleetRepository {
    @PersistenceContext(unitName = "fleet-personal")
    EntityManager entityManager;

    public Fleet retrieveFleet(int id) {
        return entityManager.find(Fleet.class, id);
    }

    public void addFleet(Fleet fleet) {
        entityManager.persist(fleet);
    }

    public void removeFleet(int fleetId) {
        Fleet fleetToRemove = retrieveFleet(fleetId);
        entityManager.remove(fleetToRemove);
    }

    public List<Fleet> retrieveAll() {
        return entityManager.createNamedQuery("allFleets").getResultList();
    }
}
