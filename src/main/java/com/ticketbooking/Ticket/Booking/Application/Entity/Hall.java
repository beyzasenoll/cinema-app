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
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;
    private String loc;
    private String name;

    @OneToMany(mappedBy="hall")
    Set<Seat> seats ;
    @OneToMany(mappedBy="hall")
    Set<Ticket> tickets ;
}