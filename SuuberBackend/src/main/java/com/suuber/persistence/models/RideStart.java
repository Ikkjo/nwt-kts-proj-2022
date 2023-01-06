package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "RideStart")
@Table(name = "ride_start")
public class RideStart extends RideStop{

    public RideStart() {
        super();
    }
}
