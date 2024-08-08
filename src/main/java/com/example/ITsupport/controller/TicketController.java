package com.example.ITsupport.controller;

import com.example.ITsupport.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PutMapping("admin/AssignTicketToTechnician/")
    public void assignTicketToTechnician(@RequestParam Integer idticket ,@RequestParam Integer idtechnician) {
        ticketService.assignTicketToTechnician(idticket, idtechnician);
    }

}
