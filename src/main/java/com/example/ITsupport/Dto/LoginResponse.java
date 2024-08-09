package com.example.ITsupport.Dto;


import com.example.ITsupport.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LoginResponse {
    private String token;
    private Person user;




}
