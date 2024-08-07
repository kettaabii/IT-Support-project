package com.example.ITsupport.controller;

import com.example.ITsupport.entity.EquipementPanne;
import com.example.ITsupport.entity.Panne;
import com.example.ITsupport.entity.PanneEquipementkey;
import com.example.ITsupport.repository.EquipementPanneRepository;
import com.example.ITsupport.service.EquipementPanneService;
import com.example.ITsupport.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PanneController {
    @Autowired
    private PanneService panneService;

    @Autowired
    private EquipementPanneService equipementPanneService;
    @PostMapping("/user/signaler")
    public String signaler(@RequestParam String description,  @RequestParam(required = false) Integer idMat,@RequestParam(required = false) Integer idPanne){
        return panneService.signalerpanne(description,idMat,idPanne);

    }
    @PostMapping("/admin/newPanne")
    public Panne newPanne(@RequestBody Panne panne){
        return panneService.newPanne(panne);
    }

    @PostMapping("/admin/setAsCommunePanne")
    public Panne setAsCommunePanne(@RequestBody PanneEquipementkey panne){
       Panne panne1 =new Panne();
        var desc =panne.getDescription();
       panne1.setPanneDescription(desc);
        var panne3 =panneService.newPanne(panne1);
       panne.setPanneId(panne3.getPanneId());
       equipementPanneService.enregistrer(panne);


        return  panne3;
    }

}
