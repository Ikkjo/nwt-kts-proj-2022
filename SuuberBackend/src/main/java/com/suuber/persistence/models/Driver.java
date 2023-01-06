package com.suuber.persistence.models;

import com.suuber.persistence.models.enumerations.DriverStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Driver")
@Table(name = "drivers")
public class Driver extends User {
    @Column(name = "phone_number",
            nullable = false)
    private String phoneNumber;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DriverStatus status;
    @OneToOne(mappedBy = "driver")
    @Column(name = "vehicle")
    private Vehicle vehicle;

    public Driver() {
    }
}
