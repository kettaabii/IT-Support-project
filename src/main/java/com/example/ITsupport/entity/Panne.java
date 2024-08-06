package com.example.ITsupport.entity;


import com.example.ITsupport.enums.TypePanne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
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

    @ManyToOne()
    @JoinColumn(name = "idMaterial")
    @JsonIgnore
    private Equipement material;

}
