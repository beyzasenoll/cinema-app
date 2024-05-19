package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDto {
    private Long tid;
    private String loc;
    private String tname;
    private Set<SeatDto> seats;
    private Set<TicketDto> tickets;
}