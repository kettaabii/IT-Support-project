package com.example.ITsupport.service;

import com.example.ITsupport.entity.*;
import com.example.ITsupport.enums.StatusMat;
import com.example.ITsupport.enums.StatusTicket;
import com.example.ITsupport.repository.EquipementPanneKeyRepo;
import com.example.ITsupport.repository.EquipementPanneRepository;
import com.example.ITsupport.repository.PanneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.example.ITsupport.enums.StatusTicket.*;

@Service
public class PanneService {
    @Autowired
    private EquipementPanneRepository equipementPanneRepository;
    @Autowired
    private EquipementPanneKeyRepo equipementPanneKeyRepoRepository;
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
        equipementService.saveEquipement(equipement);

        ticketService.newTicket(ticket);

        return "ajouté";
    }
    public Panne newPanne(Panne panne){
        return panneRepository.save(panne);
    }
    public EquipementPanne enregistrer(PanneEquipementkey key, String description) {

        Equipement equipement = equipementService.getEquipementById(key.getMaterialId());


        Panne panne = panneRepository.findById(key.getPanneId())
                .orElseThrow(() -> new EntityNotFoundException("Panne not found with id: " + key.getPanneId()));


        EquipementPanne equipementPanne = new EquipementPanne();
        equipementPanne.setId(key);
        equipementPanne.setEquipement(equipement);
        equipementPanne.setPanne(panne);



        return equipementPanneKeyRepoRepository.save(equipementPanne);
    }
    public Panne getPanneById(Integer id) {
        return panneRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Panne not found with id: " + id));
    }
    public Panne updatePanne(Integer id ,Panne panne){
        Panne panne1 =getPanneById(id);
        panne1.setPanneDescription(panne.getPanneDescription());
        panne1.setPanneTitle(panne.getPanneTitle());
        panne1.setTypePanne(panne.getTypePanne());
        return panneRepository.save(panne1);
    }

    public List<Panne> findAll() {
        return panneRepository.findAll();
    }
}
