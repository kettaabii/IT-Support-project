package com.example.ITsupport.entity;

import com.example.ITsupport.enums.StatusTicket;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private StatusTicket statusTicket;
    private LocalDateTime dateCreation;
    private LocalDateTime dateCloture;
    private int priorite;
    @ManyToOne
    private User user;
    @ManyToOne
    private Technician technician;
    @OneToOne
    private Panne panne;
}
