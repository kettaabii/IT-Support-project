package com.example.ITsupport.controller;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PutMapping("admin/AssignTicket/{idTicket}/ToTechnician/{idtechnician}")
    public void assignTicketToTechnician(@PathVariable("idTicket") Integer idticket ,@PathVariable Integer idtechnician) {
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

    @GetMapping("shared/TicketsHistoryForMat/{id}")
    public List<TicketHistoryDTO> getTicketsHistoryForMat(@PathVariable Integer id) {
        return ticketService.findTicketHistoryForMat(id);
    }
    @PutMapping("technician/AcceptTicket/{id}")
    public String acceptTicket(@PathVariable Integer id) {
        return ticketService.AcceptTicket(id);
    }



    @GetMapping("user/MyTickets/{id}")
    public List<TicketHistoryDTO> getMyTickets(@PathVariable Integer id) {
        return ticketService.getTicketsByUser(id);
    }


    @GetMapping("/admin/getPendingTickets")
    public List<TicketHistoryDTO> getPendingTickets() {
        return ticketService.getAllPendingTickets();
    }
}
