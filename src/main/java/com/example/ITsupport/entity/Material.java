package com.example.ITsupport.entity;

import com.example.ITsupport.enums.StatusMat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String materialName;
    @Enumerated(EnumType.STRING)
    private StatusMat status;


}
