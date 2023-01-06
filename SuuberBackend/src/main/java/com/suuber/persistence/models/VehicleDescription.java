package com.suuber.persistence.models;

import com.suuber.persistence.models.enumerations.VehicleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "VehicleDescription")
@Table(name = "vehicle_descriptions")
@Getter
@Setter
public class VehicleDescription {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    @OneToOne(fetch = LAZY,
              mappedBy = "description")
    private Vehicle vehicle;
    @Column( name = "model")
    private String model;
    @Column( name = "color")
    private String color;
    @Column( name = "vehicle_type")
    private VehicleType vehicleType;
    @Column( name = "capacity")
    private Integer capacity;
    @Column( name = "smoking_allowed")
    private Boolean smokingAllowed;
    @Column( name = "pet_friendly")
    private Boolean petFriendly;
    @Column( name = "baby_friendly")
    private Boolean babyFriendly;

    public VehicleDescription() {
    }
}
