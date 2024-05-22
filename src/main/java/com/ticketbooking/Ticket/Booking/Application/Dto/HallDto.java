package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallDto {
    private Long hallId;
    private String loc;
    private String name;
}