package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fleets")
@NamedQueries({
        @NamedQuery(name = "allFleets",query = "select f from Fleet f")
})
public class Fleet implements Serializable {
    @Id
    private int id;

    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
