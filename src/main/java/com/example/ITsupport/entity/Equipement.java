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
    private Integer idMaterial;
    private String materialName;
    @Enumerated(EnumType.STRING)
    private StatusMat status;


    @OneToMany(mappedBy = "material")
    @JsonIgnore
    List<Panne> panneList;

    @ManyToOne
    @JsonIgnore
    User utilisateur ;


}
