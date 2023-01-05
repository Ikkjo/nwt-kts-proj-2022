package com.suuber.persistence.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "ChatMessage")
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "sender")
    @OneToOne
    private User sender;
    @Column(name = "timestamp")
    private Long timestamp = new Date().getTime();
    @Column(name = "message_content")
    private String messageContent;

    public ChatMessage() {
    }
}
