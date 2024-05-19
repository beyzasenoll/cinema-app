package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long ticketNo;
    private int hallNo;
    private double price;
    private int seatNo;
    private CustomerDto customer;
    private ShowDetailsDto showData;
    private TheatreDto theatre;
    private Set<MovieDto> movies;
}