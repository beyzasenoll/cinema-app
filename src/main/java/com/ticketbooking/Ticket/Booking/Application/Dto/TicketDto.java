package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long ticketNo;
    private double price;
    private int seatNo;
}