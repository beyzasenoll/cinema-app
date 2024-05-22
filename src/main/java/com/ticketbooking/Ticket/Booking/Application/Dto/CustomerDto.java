package com.ticketbooking.Ticket.Booking.Application.Dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long cid;
    private String cName;
    private String email;
    private String phoneNo;
}