package com.ticketbooking.Ticket.Booking.Application.Repository;

import com.ticketbooking.Ticket.Booking.Application.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}