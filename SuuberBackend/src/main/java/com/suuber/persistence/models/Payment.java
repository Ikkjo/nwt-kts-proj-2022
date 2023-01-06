package com.suuber.persistence.models;

import com.suuber.persistence.models.enumerations.Currency;
import com.suuber.persistence.models.enumerations.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "Payment")
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @Column(name = "client")
    private Client client;
    @ManyToOne
    @Column(name = "ride")
    private Ride ride;
    @Column(name = "amount",
            nullable = false)
    private Double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency",
            nullable = false)
    private Currency currency = Currency.RSD;
    @Column(name = "status")
    private PaymentStatus status = PaymentStatus.PENDING;

    public Payment() {
    }
}
