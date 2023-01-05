package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "Review")
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @Column(name = "from_client")
    private Client from;
    @Column(name = "ride")
    private Ride ride;
    @Column(name = "driver_rating")
    private Double driverRating;
    @Column(name = "vehicle_rating")
    private Double vehicleRating;

    public Review() {
    }
}
