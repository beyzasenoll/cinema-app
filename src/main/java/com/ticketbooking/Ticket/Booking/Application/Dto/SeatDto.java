package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private Long seatNo;
    private String seatType;
    private TheatreDto theatre;
}