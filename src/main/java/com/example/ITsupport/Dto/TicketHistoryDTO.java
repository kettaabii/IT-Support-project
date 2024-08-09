package com.example.ITsupport.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class TicketHistoryDTO {
    private LocalDateTime dateSignalement;
    private String panneTitre;
    private String panneDescription;

}
