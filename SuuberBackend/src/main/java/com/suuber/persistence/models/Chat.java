package com.suuber.persistence.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

@Data
@Entity(name = "Chat")
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany
    private Collection<User> members = new HashSet<>();
    @Column(name = "created_at")
    private Long createdAtTimestamp = new Date().getTime();
    @Column(name = "messages")
    @OneToMany
    private Collection<ChatMessage> messages = new HashSet<>();

    public Chat(){
    }
}
