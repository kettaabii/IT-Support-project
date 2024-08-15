package com.example.ITsupport;
import com.example.ITsupport.Dto.TicketHistoryDTO;
import com.example.ITsupport.controller.TicketController;
import com.example.ITsupport.entity.Ticket;
import com.example.ITsupport.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class TicketControllerTest {
    private MockMvc mockMvc;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private TicketController ticketController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
    }

    

    @Test
    void testGetTicketsByTec() throws Exception {
        List<Ticket> tickets = Arrays.asList(new Ticket(), new Ticket());
        when(ticketService.getAllTicketsByTechnician(anyInt())).thenReturn(tickets);

        mockMvc.perform(get("/admin/getTicketsByTec/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));

        verify(ticketService, times(1)).getAllTicketsByTechnician(1);
    }

    @Test
    void testGetAssignedTickets() throws Exception {
        List<Ticket> tickets = Arrays.asList(new Ticket(), new Ticket(), new Ticket());
        when(ticketService.getAssignedTickets(anyInt())).thenReturn(tickets);

        mockMvc.perform(get("/technician/AssignedTickets/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3));

        verify(ticketService, times(1)).getAssignedTickets(1);
    }

    @Test
    void testGetTicketsHistoryForMat() throws Exception {
        List<TicketHistoryDTO> ticketHistory = Arrays.asList(new TicketHistoryDTO(), new TicketHistoryDTO());
        when(ticketService.findTicketHistoryForMat(anyInt())).thenReturn(ticketHistory);

        mockMvc.perform(get("/shared/TicketsHistoryForMat/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));

        verify(ticketService, times(1)).findTicketHistoryForMat(1);
    }
}
