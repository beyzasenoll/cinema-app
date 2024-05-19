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
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    private String loc;
    private String tname;

    @OneToMany(mappedBy="theatre")
    Set<Seat> seats ;
    @OneToMany(mappedBy="theatre")
    Set<Ticket> tickets ;
}