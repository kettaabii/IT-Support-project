package com.example.ITsupport.entity;

import com.example.ITsupport.enums.StatusMat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material-id")
    private Integer materialId;
    private String materialName;
    private String picture;
    @Enumerated(EnumType.STRING)
    private StatusMat status;


    @OneToMany(mappedBy = "equipement")
    @JsonIgnore
    List<EquipementPanne> panneMaterialList;

    @ManyToOne
    @JsonIgnore
    User utilisateur ;



}
