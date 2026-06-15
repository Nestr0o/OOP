package com.example.demo;

import com.example.demo.dto.TicketCreateDto;
import com.example.demo.model.Ticket;
import com.example.demo.model.TicketStatus;
import com.example.demo.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    void createTicketTest() {
        TicketCreateDto dto = new TicketCreateDto();
        dto.setCustomerName("Test User");
        dto.setTitle("Test title");
        dto.setDescription("Test description");

        Ticket ticket = ticketService.createTicket(dto);

        assertNotNull(ticket);
        assertNotNull(ticket.getId());
        assertEquals("Test User", ticket.getCustomerName());
        assertEquals("Test title", ticket.getTitle());
        assertEquals("Test description", ticket.getDescription());
        assertEquals(TicketStatus.NEW, ticket.getStatus());
        assertNotNull(ticket.getCreatedAt());
    }

    @Test
    void getAllTicketsTest() {
        TicketCreateDto dto = new TicketCreateDto();
        dto.setCustomerName("List User");
        dto.setTitle("List title");
        dto.setDescription("List description");

        ticketService.createTicket(dto);

        List<Ticket> tickets = ticketService.getAllTickets();

        assertNotNull(tickets);
        assertFalse(tickets.isEmpty());
    }

    @Test
    void getTicketByIdTest() {
        TicketCreateDto dto = new TicketCreateDto();
        dto.setCustomerName("Search User");
        dto.setTitle("Search title");
        dto.setDescription("Search description");

        Ticket savedTicket = ticketService.createTicket(dto);

        Ticket foundTicket = ticketService.getTicketById(savedTicket.getId());

        assertNotNull(foundTicket);
        assertEquals(savedTicket.getId(), foundTicket.getId());
        assertEquals("Search User", foundTicket.getCustomerName());
        assertEquals("Search title", foundTicket.getTitle());
    }
}