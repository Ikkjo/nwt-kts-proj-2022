package com.suuber.persistence.models;

import com.suuber.persistence.models.enumerations.RideStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Data
@Entity(name = "Ride")
@Table(name = "rides")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id",
                nullable = false)
    private Driver driver;
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JoinColumn(name = "client_id")
    private Collection<Client> clients = new HashSet<>();
    @Enumerated(EnumType.STRING)
    @Column(name = "ride_status")
    private RideStatus rideStatus;
    @Column(name = "start_time")
    private Long startTime;
    @Column(name = "end_time")
    private Long endTime;
    @Column(name = "distance")
    private Double distance;

    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JoinColumn(name = "route_stop_id")
    private Collection<RideStop> route = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JoinColumn(name = "review_id")
    private Collection<Review> reviews = new HashSet<>();

    public Ride() {
    }
}
