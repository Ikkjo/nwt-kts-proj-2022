package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "RideEnd")
@Table(name = "ride_end")
public class RideEnd extends RideStop {

    public RideEnd() {
        super();
    }
}
