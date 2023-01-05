package com.suuber.persistence.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "Address")
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "street_name")
    private String name;
    @Column(name = "latitude")
    private Double latitude = 0.0;
    @Column(name = "longitude")
    private Double longitude = 0.0;

    public Address() {

    }
}
