package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "Complaint")
@Table(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "from_user",
            nullable = false)
    private User from;
    @Column(name = "to_user",
            nullable = false)
    private User to;
    @Column(name = "complaint_message",
            nullable = false)
    private String complaintMessage;
}
