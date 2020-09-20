package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "allCustomers", query = "select c from Customer c")
})
public class Customer implements Serializable {
    @Id
    private int id;

    @Column(name = "vehicle_vin")
    private String vehicleVin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }
}
