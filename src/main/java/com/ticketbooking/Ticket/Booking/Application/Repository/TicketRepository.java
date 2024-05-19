package com.ticketbooking.Ticket.Booking.Application.Repository;

import com.ticketbooking.Ticket.Booking.Application.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
