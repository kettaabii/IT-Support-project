package com.example.ITsupport.entity;

import com.example.ITsupport.enums.role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
public class Admin extends Person{
    @Override
    public role getRole() {
        return role.ADMIN;
    }
}
