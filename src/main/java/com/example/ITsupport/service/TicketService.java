package com.example.ITsupport.service;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.Panne;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.enums.StatusMat;
import com.example.ITsupport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.ITsupport.enums.StatusTicket.ENATTENTE;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EquipementService equipementService;
    public Ticket newTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    public Ticket signalerpanne(Panne panne, Integer idMat){
        Equipement equipement = equipementService.getEquipementById(idMat);
        equipement.setStatus(StatusMat.PANNE);
        panne.setMaterial(equipement);
        Ticket ticket = new Ticket();
        ticket.setPanne(panne);
        ticket.setDateCreation(panne.getDateSignalement());
        ticket.setStatusTicket(ENATTENTE);

        return  ticketRepository.save(ticket);
    }

}
