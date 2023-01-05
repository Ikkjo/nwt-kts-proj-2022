package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "Client")
@Table(name = "clients")
public class Client extends User {

    @Column(name = "phone_number",
            nullable = false)
    private String phoneNumber;
    @Column(name = "payment_info",
            nullable = false)
    private String paymentInfo;

    public Client() {
        super();
    }

}
