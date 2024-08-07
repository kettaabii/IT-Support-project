package com.example.ITsupport.service;

import com.example.ITsupport.entity.PanneEquipementkey;
import com.example.ITsupport.repository.EquipementPanneKeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipementPanneService {

    @Autowired
    private EquipementPanneKeyRepo equipementPanneKeyRepo;

    public PanneEquipementkey enregistrer(PanneEquipementkey panneEquipementkey){
       return equipementPanneKeyRepo.save(panneEquipementkey);
    }
}
