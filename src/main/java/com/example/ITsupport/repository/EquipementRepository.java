package com.example.ITsupport.repository;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipementRepository extends JpaRepository<Equipement, Integer> {
    List<Equipement> findAllByUtilisateurIs(User user);

}
