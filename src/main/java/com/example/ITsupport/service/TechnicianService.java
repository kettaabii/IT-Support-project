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

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonRepository personRepository;


    public Technician findTechnicianById(Integer technicianId) {
        return technicianRepository.findById(technicianId).orElse(null);
    }
    @Transactional
    public void signUp(SignupRequest signupRequest) {
        String hashedPassword = passwordEncoder.encode(signupRequest.password());
        Technician user = new Technician();
        user.setUsername(signupRequest.username());
        user.setEmail(signupRequest.email());
        user.setPhone(signupRequest.phone());
        user.setPassword(hashedPassword);
        user.setRole(role.TECHNICIAN);

        technicianRepository.save(user);
    }

    public Technician updateTechnician(Integer id , SignupRequest technicianRequest) {
        Technician technician = technicianRepository.findById(id).get();
        technician.setUsername(technicianRequest.username());
        technician.setEmail(technicianRequest.email());
        technician.setPhone(technicianRequest.phone());
        technician.setPassword(technicianRequest.password());
        return technicianRepository.save(technician);
    }

    public String removeTechnician(Integer id)
    {
        Technician technician = technicianRepository.findById(id).get();
        technicianRepository.delete(technician);
        return "delete success";
    }

}
