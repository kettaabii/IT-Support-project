package com.example.ITsupport.service;

import com.example.ITsupport.entity.*;
import com.example.ITsupport.repository.TechnicianRepository;
import com.example.ITsupport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import static com.example.ITsupport.enums.StatusTicket.ABOUTIT;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EquipementService equipementService;
    @Autowired
    private PersonService personService;
    @Autowired
    private TechnicianRepository technicianRepository;


    public Ticket newTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    public Ticket assignTicketToTechnician(Integer ticketId, Integer technicianId) {
        var ticket = ticketRepository.findById(ticketId).get();
        var technician = technicianRepository.findById(technicianId).get();

        ticket.setTechnician(technician);
        ticket.setStatusTicket(ABOUTIT);
        technicianRepository.save(technician);
        return ticketRepository.save(ticket);
    }


}
