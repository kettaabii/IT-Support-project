package com.example.ITsupport.entity;

import com.example.ITsupport.enums.StatusTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @AllArgsConstructor @NoArgsConstructor @Setter @Getter
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

    @ManyToOne
    private EquipementPanne equipementPanne;
}
