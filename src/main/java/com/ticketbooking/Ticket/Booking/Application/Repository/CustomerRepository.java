package com.ticketbooking.Ticket.Booking.Application.Repository;

import com.ticketbooking.Ticket.Booking.Application.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}