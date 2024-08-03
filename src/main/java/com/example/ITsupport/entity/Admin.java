package com.example.ITsupport.entity;

import com.example.ITsupport.enums.role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin extends Person{
    @Enumerated(EnumType.STRING)
    private com.example.ITsupport.enums.role role;
}
