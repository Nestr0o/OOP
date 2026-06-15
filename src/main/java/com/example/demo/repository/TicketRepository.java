package com.example.demo.repository;
import java.util.List;

import com.example.demo.model.Ticket;
import com.example.demo.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}


