package com.example.ITsupport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PanneEquipementkey implements Serializable {

    @Column(name="material_id")
    private Integer materialId;

    @Column(name="panne_id")
    private Integer panneId;
    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanneEquipementkey that = (PanneEquipementkey) o;
        return Objects.equals(materialId, that.materialId) && Objects.equals(panneId, that.panneId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, panneId, description);
    }
}
