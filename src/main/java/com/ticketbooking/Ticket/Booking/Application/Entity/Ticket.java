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
    private int hallNo;
    private double price;
    private int seatNo;
    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showDetailsId", referencedColumnName = "showDetailsId")
    private ShowDetails showDetails;
    @ManyToOne
    @JoinColumn(name="tid", nullable=false)
    private Theatre theatre;

    @ManyToMany(mappedBy = "movieTicket")
    Set<Movie> movies;

}