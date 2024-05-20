package com.ticketbooking.Ticket.Booking.Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "showDetails", "hall", "movies"})
@EqualsAndHashCode(exclude = {"customer", "showDetails", "hall", "movies"})
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