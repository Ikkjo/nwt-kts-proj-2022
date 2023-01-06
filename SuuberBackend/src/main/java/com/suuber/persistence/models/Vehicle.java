package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "Vehicle")
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "license_plate",
            nullable = false)
    private String licensePlate;
    @OneToOne(mappedBy = "vehicle",
              fetch = FetchType.LAZY)
    private Driver driver;
    @OneToOne(mappedBy = "vehicle",
              cascade = CascadeType.ALL,
              orphanRemoval = true,
              fetch = FetchType.LAZY)
    private VehicleDescription description;

    public Vehicle() {
    }
}
