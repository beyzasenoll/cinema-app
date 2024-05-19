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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketNo;
    private double price;
    private int seatNo;
    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showDetailsId", referencedColumnName = "showDetailsId")
    private ShowDetails showDetails;
    @ManyToOne
    @JoinColumn(name="hallId", nullable=false)
    private Hall hall;

    @ManyToMany(mappedBy = "movieTicket")
    Set<Movie> movies;

}