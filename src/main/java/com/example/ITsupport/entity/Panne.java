package com.example.ITsupport.entity;


import com.example.ITsupport.enums.TypePanne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "panne-id")
    private Integer panneId;
    private String panneTitle;
    private String panneDescription;

    @Enumerated(EnumType.STRING)
    private TypePanne typePanne;


    @OneToMany(mappedBy = "panne")
    @JsonIgnore
    private List<EquipementPanne> ListePanneEquipement;





}
