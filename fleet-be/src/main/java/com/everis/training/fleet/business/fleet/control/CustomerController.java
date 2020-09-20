package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerController {
    @Inject
    CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Customer retrieveCustomer(int id) {
        return customerRepository.retrieveCustomer(id);
    }

    public void removeCustomer(int id) {
        customerRepository.removeCustomer(id);
    }

    public List<Customer> retrieveAll() {
        return customerRepository.retrieveAll();
    }

    public void finishReservation(int id) {
        customerRepository.finishReservation(id);
    }
}
