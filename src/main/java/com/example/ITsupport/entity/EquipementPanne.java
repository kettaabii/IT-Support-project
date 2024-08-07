package com.example.ITsupport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class EquipementPanne {
    @EmbeddedId
    private PanneEquipementkey id;



    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name="material_id")
    private Equipement equipement;

    @ManyToOne
    @MapsId("panneId")
    @JoinColumn(name="panne_id")
    private Panne panne ;
}
