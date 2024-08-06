package com.example.ITsupport.service;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.Panne;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.enums.StatusMat;
import com.example.ITsupport.enums.StatusTicket;
import com.example.ITsupport.repository.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.ITsupport.enums.StatusTicket.*;

@Service
public class PanneService {
    @Autowired
    private  PanneRepository panneRepository;
    @Autowired
    private EquipementService equipementService;
    @Autowired
    private TicketService ticketService;

    public Panne signalerpanne(Panne panne,Integer idMat){
        Ticket ticket =new Ticket();
        Equipement equipement = equipementService.getEquipementById(idMat);
        equipement.setStatus(StatusMat.PANNE);
        panne.setMaterial(equipement);
        Panne panne1 =panneRepository.save(panne);
        ticket.setPanne(panne1);
        ticket.setDateCreation(panne.getDateSignalement());
        ticket.setStatusTicket(ENATTENTE);
        ticketService.newTicket(ticket);
        return  panne1;
    }

}
