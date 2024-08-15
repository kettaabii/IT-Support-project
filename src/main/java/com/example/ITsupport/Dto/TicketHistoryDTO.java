package com.example.ITsupport.Dto;

import com.example.ITsupport.enums.StatusTicket;
import com.example.ITsupport.enums.TypePanne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class TicketHistoryDTO {
    private Integer id;
    private LocalDateTime dateSignalement;
    private String panneTitre;
    private String panneDescription;
    private StatusTicket statusTicket;
    private TypePanne typePanne;


}
