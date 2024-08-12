package com.example.ITsupport.controller;

import com.example.ITsupport.Dto.SignupRequest;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @PostMapping("admin/newTechnician")
    public String newTechnician(@RequestBody SignupRequest technician) {
        technicianService.signUp(technician);
        return "success" ;
    }

    @PutMapping("admin/updateTechnician/{id}")
    public Technician updateTechnician(@PathVariable Integer id, @RequestBody SignupRequest technician) {
        return technicianService.updateTechnician(id ,technician);
    }

    @DeleteMapping("admin/deleteTechnician/{id}")
    public String deleteTechnician(@PathVariable Integer id) {
        technicianService.removeTechnician(id);
        return "success" ;
    }

    @GetMapping("admin/AvailableTechnicians")
    public List<Technician> getAllAvailableTechnicians() {
        return technicianService.getAvailableTechnicians();
    }





}
