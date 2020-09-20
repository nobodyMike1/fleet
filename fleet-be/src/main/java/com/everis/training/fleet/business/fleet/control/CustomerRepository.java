package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {
    @PersistenceContext(unitName = "fleet-personal")
    EntityManager entityManager;

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer retrieveCustomer(int id) {
        return entityManager.find(Customer.class, id);
    }

    public void removeCustomer(int id) {
        Customer customerToRemove = retrieveCustomer(id);
        entityManager.remove(customerToRemove);
    }

    public List<Customer> retrieveAll() {
        return entityManager.createNamedQuery("allCustomers").getResultList();
    }

    public void finishReservation(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        customer.setVehicleVin(null);
    }
}
