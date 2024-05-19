package com.ticketbooking.Ticket.Booking.Application.Repository;

import com.ticketbooking.Ticket.Booking.Application.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}