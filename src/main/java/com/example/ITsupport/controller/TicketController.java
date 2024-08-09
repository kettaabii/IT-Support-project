package com.example.ITsupport.controller;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PutMapping("admin/AssignTicketToTechnician/")
    public void assignTicketToTechnician(@RequestParam Integer idticket ,@RequestParam Integer idtechnician) {
        ticketService.assignTicketToTechnician(idticket, idtechnician);
    }
    @GetMapping("admin/getTicketsByTec/{id}")
    public List<Ticket> getTicketsByTec(@PathVariable Integer id) {
        return ticketService.getAllTicketsByTechnician(id);
    }
    @GetMapping("technician/AssignedTickets/{id}")
    public List<Ticket> getAssignedTickets(@PathVariable Integer id) {
        return ticketService.getAssignedTickets(id);
    }
    @GetMapping("admin/TicketsHistoryForMat/{id}")
    public List<TicketHistoryDTO> getTicketsHistoryForMat(@PathVariable Integer id) {
        return ticketService.findTicketHistoryForMat(id);
    }
    @PutMapping("technician/AcceptTicket/{id}")
    public String acceptTicket(@PathVariable Integer id) {
        return ticketService.AcceptTicket(id);
    }


}
