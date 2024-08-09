package com.example.ITsupport.controller;

import com.example.ITsupport.entity.EquipementPanne;
import com.example.ITsupport.entity.Panne;
import com.example.ITsupport.entity.PanneEquipementkey;
import com.example.ITsupport.repository.EquipementPanneRepository;
import com.example.ITsupport.service.EquipementPanneService;
import com.example.ITsupport.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PanneController {
    @Autowired
    private PanneService panneService;

    @Autowired
    private EquipementPanneService equipementPanneService;
    @PostMapping("/user/signaler/{idUser}")
    public String signaler(@RequestParam String description,  @RequestParam Integer idMat,@RequestParam Integer idPanne , @PathVariable("idUser") Integer idUser){
        return panneService.signalerpanne(description,idMat,idPanne,idUser);

    }
    @PostMapping("/admin/newPanne")
    public Panne newPanne(@RequestBody Panne panne){
        return panneService.newPanne(panne);
    }


    @PostMapping("/admin/setAsCommunePanne")
    public Panne setAsCommunePanne(@RequestBody PanneEquipementkey panne) {
        Panne nouvellePanne = new Panne();
        nouvellePanne.setPanneDescription(panne.getDescription());
        nouvellePanne = panneService.newPanne(nouvellePanne);

        PanneEquipementkey key = new PanneEquipementkey();
        key.setMaterialId(panne.getMaterialId());
        key.setPanneId(nouvellePanne.getPanneId());
        key.setDescription(panne.getDescription());
        panneService.enregistrer(key, panne.getDescription());

        return nouvellePanne;
    }

    @PutMapping ("/admin/upatePanne/{id}")
    public String updatePanne(@PathVariable Integer id, @RequestBody Panne panne){

        panneService.updatePanne(id ,panne);

        return "updated";
    }

    @GetMapping("/admin/allPanne")
    public ResponseEntity<List<Panne>> getAllPannes() {
        List<Panne> pannes = panneService.findAll();
        return ResponseEntity.ok(pannes);
    }



}
