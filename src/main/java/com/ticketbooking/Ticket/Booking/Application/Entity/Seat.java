package com.ticketbooking.Ticket.Booking.Application.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatNo;
    private String seatType;

    @ManyToOne
    @JoinColumn(name="tid", nullable=false)
    private Theatre theatre;

}