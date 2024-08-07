package com.example.ITsupport.service;

import com.example.ITsupport.entity.*;
import com.example.ITsupport.enums.StatusMat;
import com.example.ITsupport.enums.StatusTicket;
import com.example.ITsupport.repository.EquipementPanneRepository;
import com.example.ITsupport.repository.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.example.ITsupport.enums.StatusTicket.*;

@Service
public class PanneService {
    @Autowired
    private EquipementPanneRepository equipementPanneRepository;
    @Autowired
    private  PanneRepository panneRepository;
    @Autowired
    private EquipementService equipementService;
    @Autowired
    private TicketService ticketService;

    public String signalerpanne(String description, Integer idMat, Integer idPanne) {
        Equipement equipement = equipementService.getEquipementById(idMat);
        Panne panne1 = panneRepository.findById(idPanne).orElseThrow(() -> new IllegalArgumentException("Panne not found"));
        System.out.println(panne1.getPanneTitle() + "panne from id : ");

        EquipementPanne equipementPanne = new EquipementPanne(new PanneEquipementkey(idPanne, idMat, description), equipement, panne1);
        equipementPanne = equipementPanneRepository.save(equipementPanne);  // Save EquipementPanne first

        Ticket ticket = new Ticket();
        ticket.setEquipementPanne(equipementPanne);
        ticket.setDateCreation(LocalDateTime.now());
        ticket.setStatusTicket(ENATTENTE);

        equipement.setStatus(StatusMat.PANNE);
        equipementService.saveEquipement(equipement);  // Save the updated Equipement

        ticketService.newTicket(ticket);  // This should now work without throwing an exception

        return "ajouté";
    }
    public Panne newPanne(Panne panne){
        return panneRepository.save(panne);
    }

}
