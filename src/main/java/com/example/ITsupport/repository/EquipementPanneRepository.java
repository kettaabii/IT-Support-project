package com.example.ITsupport.repository;

import com.example.ITsupport.entity.EquipementPanne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementPanneRepository extends JpaRepository<EquipementPanne, Long> {

}
