package com.example.ITsupport.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record SignupRequest(
        String username ,
        String email,
        String phone,
        String password
) {
}
