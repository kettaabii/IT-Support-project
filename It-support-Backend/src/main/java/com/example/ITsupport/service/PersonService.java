package com.example.ITsupport.service;

import com.example.ITsupport.Dto.SignupRequest;
import com.example.ITsupport.entity.Admin;
import com.example.ITsupport.entity.Person;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.enums.role;
import com.example.ITsupport.repository.PersonRepository;
import com.example.ITsupport.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class PersonService  {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignupRequest signupRequest) {
        String hashedPassword = passwordEncoder.encode(signupRequest.password());
        Person user = new Admin(); // Default user type
        user.setUsername(signupRequest.username());
        user.setEmail(signupRequest.email());
        user.setPhone(signupRequest.phone());
        user.setPassword(hashedPassword);
        user.setRole(role.ADMIN);

        personRepository.save(user);
    }

    public Person findUserByUsername(String username) {
        return personRepository.findByUsername(username);
    }


}
