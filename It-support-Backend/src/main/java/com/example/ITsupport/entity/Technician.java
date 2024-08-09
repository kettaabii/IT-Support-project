package com.example.ITsupport.entity;

import com.example.ITsupport.enums.role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Technician extends Person {
    @OneToMany(mappedBy = "technician")
    private List<Ticket> tickets;


    @Override
    public role getRole() {
        return com.example.ITsupport.enums.role.TECHNICIAN;
    }

}
