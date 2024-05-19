package com.ticketbooking.Ticket.Booking.Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String mName;
    private Date releaseDate;
    private String director;
    private String producer;
    private String actors;
    private double budget;
    private int duration;
    private double rating;

    @ManyToMany
    @JoinTable(
            name = "movieTicket",
            joinColumns = @JoinColumn(name = "movideId"),
            inverseJoinColumns = @JoinColumn(name = "ticketId"))
    Set<Ticket> movieTicket;
}