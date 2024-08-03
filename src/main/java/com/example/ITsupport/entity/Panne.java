package com.example.ITsupport.entity;

import com.example.ITsupport.enums.StatusPanne;
import com.example.ITsupport.enums.TypePanne;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String panneTitle;
    private String panneDescription;

    @Enumerated(EnumType.STRING)
    private TypePanne typePanne;
    private LocalDateTime dateSignalement;
    private LocalDateTime dateResolution;
    @ManyToOne
    private Material material;

}
