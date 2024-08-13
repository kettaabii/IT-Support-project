package com.example.ITsupport.controller;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    @PostMapping("/admin/AddNewEquipement")
    public ResponseEntity<Equipement> newEquipement(@RequestBody Equipement equipement) {
        Equipement nouvelleEquipement=equipementService.addNewEquipement(equipement);;

        return new ResponseEntity<>(nouvelleEquipement, HttpStatus.CREATED);
    }
    @PutMapping("admin/updateEquipement/{id}")
    public ResponseEntity<Equipement> modifierEquipement(
            @PathVariable("id") Integer equipementId,
            @RequestBody Equipement equipement) {
        Equipement equipementUpdated = equipementService.modifyEquipement(equipementId, equipement);
        return new ResponseEntity<>(equipementUpdated, HttpStatus.OK);
    }
   @DeleteMapping("admin/deleteEquipement/{id}")
    public ResponseEntity<Equipement> deleteEquipement(@PathVariable("id") Integer equipementId) {
        equipementService.removeEquipement(equipementId);
        return new ResponseEntity<>(HttpStatus.OK);
   }
   @GetMapping("admin/listEquipements")
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipements();
        return new ResponseEntity<>(equipements, HttpStatus.OK);
   }
   @PutMapping("admin/AssignEquipement{idMat}/ToUser/{idUser}")
    public ResponseEntity<Equipement> assignEquipementToUser(@PathVariable("idMat") Integer idmat ,@PathVariable("idUser") Integer idUser) {
       equipementService.AssignEquipemeToUser(idmat, idUser);
       return new ResponseEntity<>(HttpStatus.OK);
   }
    @GetMapping("shared/equipementPerUser/{id}")
    public ResponseEntity<List<Equipement>> getEquipementPerUser(@PathVariable Integer id) {
        List<Equipement> equipements = equipementService.EquipementsofUser(id);
        System.out.println(equipements.size());
        return new ResponseEntity<>(equipements, HttpStatus.OK);
    }

    @GetMapping("/admin/getEquipmentById/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Integer id) {
        Equipement equipement = equipementService.findEquipementById(id);
        return ResponseEntity.ok(equipement);
    }



   }






