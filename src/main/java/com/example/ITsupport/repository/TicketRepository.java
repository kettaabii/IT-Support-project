package com.example.ITsupport.repository;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.entity.User;
import com.example.ITsupport.enums.StatusTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {




    List<Ticket> findAllByTechnician(Technician technician);

  List<Ticket> findAllByTechnicianAndStatusTicket(Technician technician, StatusTicket statusTicket);

   List<Ticket> findAllByEquipementPanne_Equipement_MaterialId(Integer materialId);

    List<Ticket> findAllByUser(User user);
    List<Ticket> findAllByStatusTicket(StatusTicket statusTicket);

}
