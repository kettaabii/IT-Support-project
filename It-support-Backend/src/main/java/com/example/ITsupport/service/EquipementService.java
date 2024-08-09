package com.example.ITsupport.service;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.User;
import com.example.ITsupport.repository.EquipementPanneRepository;
import com.example.ITsupport.repository.EquipementRepository;
import com.example.ITsupport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;
    @Autowired
    private UserRepository userRepository;


    public Equipement addNewEquipement(Equipement equipment) {
        equipementRepository.save(equipment);
        return equipment;
    }

    public Equipement modifyEquipement(Integer equipementId ,Equipement equipment) {
       Equipement equipement1= equipementRepository.findById(equipementId).get();
       equipement1.setMaterialName(equipment.getMaterialName());
       equipement1.setStatus(equipment.getStatus());
      return equipementRepository.save(equipement1);

    }


    public Equipement removeEquipement(Integer equipementId) {
        Equipement equipment1= equipementRepository.findById(equipementId).get();
        equipementRepository.delete(equipment1);
        return equipment1;
    }

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
    public Equipement getEquipementById(Integer equipementId) {
        return equipementRepository.findById(equipementId).get();
    }

    public Equipement saveEquipement(Equipement equipment) {
        return equipementRepository.save(equipment);
    }

    public String AssignEquipemeToUser(Integer idmat, Integer idUser) {
        Equipement equipement = equipementRepository.findById(idmat).get();
        System.out.println(equipement.getMaterialName()+"methode assigner Material  id");
        User user = userRepository.findById(idUser).get();
        System.out.println(user.getId()+"methode assigner user id");
        equipement.setUtilisateur(user);
        equipementRepository.save(equipement);
        return "sucessfully assigned";
    }

    public List<Equipement> EquipementsofUser(Integer id) {
        User user = userRepository.findById(id).get();
        System.out.println("luser " + user.getId());
        return equipementRepository.findAllByUtilisateurIs(user);
    }

    public Equipement findEquipementById(Integer id) {
        return equipementRepository.findById(id).get();
    }
}
