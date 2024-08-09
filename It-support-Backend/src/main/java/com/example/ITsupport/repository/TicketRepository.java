package com.example.ITsupport.repository;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.entity.Equipement;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.entity.User;
import com.example.ITsupport.enums.StatusTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {




    List<Ticket> findAllByTechnician(Technician technician);
 // List<Ticket> findAllByTechnicianAnAndStatusTicketEnattente(Technician technician, StatusTicket statusTicket);
  List<Ticket> findAllByTechnicianAndStatusTicket(Technician technician, StatusTicket statusTicket);
//   List<Ticket> findAllByEquipementMaterialId(Integer equipementMaterialId);
//   List<Ticket> findAllByEquipement_Material_Id(Integer equipement_Material_Id);
//   List<Ticket> findAllByEquipementPanne_Equipement(Equipement equipement);
//   @Query("SELECT t FROM Ticket t WHERE t.equipementPanne.equipement.materialId= :equipementId")
//  List<Ticket> findAllTicketsForEquipement(@Param("equipementId") Integer equipementId);
   List<Ticket> findAllByEquipementPanne_Equipement_MaterialId(Integer materialId);

    List<Ticket> findAllByUser(User user);
//  @Query("SELECT new com.example.ITsupport.Dto.TicketHistoryDTO(t.dateCreation, t.equipementPanne.panne.panneDescription, t.equipementPanne.id.description) " +
//          "FROM Ticket t WHERE t.equipementPanne.equipement.materialId = :materialId")
//  List<Ticket> findTicketHistoryForEquipement(@Param("materialId") Integer materialId);

}
