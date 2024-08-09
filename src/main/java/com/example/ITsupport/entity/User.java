package com.example.ITsupport.entity;

import com.example.ITsupport.enums.role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity  @Getter @Setter
public class User extends Person {


    @Override
    public com.example.ITsupport.enums.role getRole() {
        return role.USER;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Ticket> tickets;

    @OneToMany
    @JsonIgnore
    private List<Equipement> equipements ;


}
