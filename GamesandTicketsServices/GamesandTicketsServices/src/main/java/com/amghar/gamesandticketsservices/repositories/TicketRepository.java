package com.amghar.gamesandticketsservices.repositories;

import com.amghar.gamesandticketsservices.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
