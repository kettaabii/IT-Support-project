package com.example.ITsupport.controller;

import com.example.ITsupport.entity.Panne;
import com.example.ITsupport.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanneController {
    @Autowired
    private PanneService panneService;

    @PostMapping("/user/signaler/{id}")
    public Panne signaler(@RequestBody Panne panne, @PathVariable Integer id){
        return panneService.signalerpanne(panne,id);

    }

}
