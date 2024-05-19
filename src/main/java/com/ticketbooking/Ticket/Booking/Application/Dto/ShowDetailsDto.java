package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDetailsDto {
    private Long showDetailsId;
    private String date;
    private String stTime;
    private String endTime;
    private String lang;
    private TicketDto ticket;
}