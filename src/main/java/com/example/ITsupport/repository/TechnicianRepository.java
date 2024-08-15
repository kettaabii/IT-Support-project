package com.example.ITsupport.repository;

import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.enums.inDuty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    Technician findById(int id);
    List<Technician> findAllByInDutyIs(inDuty inDuty);
//    @Query(value = "select t.username from Technician t inner join Ticket k on t.id=k.technician.id where k.equipementPanne.equipement.materialId=:id")
//    String technicienName(@Param("id") Integer id);
//    @Query(value = "select e.* from Equipement e Inner Join Ticket t on e.`material-id`=t.equipement_panne_material_id where t.technician_id=?" ,nativeQuery = true )
  //  List<Equipement> equipements(Integer id);



}
