package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "RideStop")
@Table(name = "ride_stop")
public class RideStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @Column(name = "address")
    private Address address;
    @Column(name = "stop_reached_at")
    private Long stopReachedAtTimestamp;

    public RideStop() {
    }
}
