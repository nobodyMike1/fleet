package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
@NamedQueries({
        @NamedQuery(name = "allVehicles", query = "select v from Vehicle v"),
        @NamedQuery(name = "unreservedVehicles", query = "select v from Vehicle v where" +
                " not exists (select c from Customer c where c.vehicleVin = v.vin)")
})
public class Vehicle implements Serializable {
    @Id
    private String vin;

    @Column(name = "fleet_id")
    private int fleetId;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }
}
