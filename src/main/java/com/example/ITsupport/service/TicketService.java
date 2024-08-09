package com.example.ITsupport.service;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.Mapper.TicketMapper;
import com.example.ITsupport.entity.*;
import com.example.ITsupport.enums.StatusTicket;
import com.example.ITsupport.repository.TechnicianRepository;
import com.example.ITsupport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

import static com.example.ITsupport.enums.StatusTicket.ABOUTIT;
import static com.example.ITsupport.enums.StatusTicket.ENATTENTE;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EquipementService equipementService;
    @Autowired
    private PersonService personService;
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private TicketMapper ticketMapper ;


    public Ticket newTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    public Ticket assignTicketToTechnician(Integer ticketId, Integer technicianId) {
        var ticket = ticketRepository.findById(ticketId).get();
        var technician = technicianRepository.findById(technicianId).get();

        ticket.setTechnician(technician);
        ticket.setStatusTicket(ABOUTIT);
        ticket.setDateReception(LocalDateTime.now());
        technicianRepository.save(technician);
        return ticketRepository.save(ticket);
    }
    public List<Ticket> getAllTicketsByTechnician(Integer technicianId) {
        Technician technician=technicianRepository.findById(technicianId).get();
        return ticketRepository.findAllByTechnician(technician);
    }

//    public List<Ticket> getAssignedTickets(Integer id) {
//        Technician technician=technicianRepository.findById(id).get();
//        StatusTicket statusTicket=ENATTENTE;
//        return ticketRepository.findAllByTechnicianAnAndStatusTicketEnattente(technician,statusTicket);
//    }


//    public List<TicketHistoryDTO> findAllForMat(Integer id) {
//        List<Ticket> tickets = ticketRepository.findTicketHistoryForEquipement(id);
//        return ticketMapper.ticketsToTicketHistoryDTOs(tickets);
//    }
    public List<TicketHistoryDTO> findTicketHistoryForMat(Integer materialId) {
        List<Ticket> tickets = ticketRepository.findAllByEquipementPanne_Equipement_MaterialId(materialId);
        return ticketMapper.ticketsToTicketHistoryDTOs(tickets);
    }

}
