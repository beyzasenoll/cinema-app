package com.ticketbooking.Ticket.Booking.Application.Repository;

import com.ticketbooking.Ticket.Booking.Application.Entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}