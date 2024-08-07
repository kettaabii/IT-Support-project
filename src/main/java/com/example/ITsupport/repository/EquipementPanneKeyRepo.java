package com.example.ITsupport.repository;

import com.example.ITsupport.entity.PanneEquipementkey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementPanneKeyRepo extends JpaRepository<PanneEquipementkey ,Integer> {
}
