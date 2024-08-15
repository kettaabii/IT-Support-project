package com.example.ITsupport.Mapper;

import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.entity.Ticket;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface TicketMapper {
    @Mapping(source= "id",target="id")
    @Mapping(source = "dateCreation", target = "dateSignalement")
    @Mapping(source = "equipementPanne.panne.panneTitle", target = "panneTitre")
    @Mapping(source = "equipementPanne.id.description", target = "panneDescription")
    @Mapping(source = "statusTicket", target = "statusTicket")

    TicketHistoryDTO ticketToTicketHistoryDTO(Ticket ticket);
    Ticket toEntity(TicketHistoryDTO ticketDto);

    List<TicketHistoryDTO> ticketsToTicketHistoryDTOs(List<Ticket> tickets);
}
