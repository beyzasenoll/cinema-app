package com.ticketbooking.Ticket.Booking.Application.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTicketRequestDto {
    private Long customerId;
    private Long ticketId;
}
