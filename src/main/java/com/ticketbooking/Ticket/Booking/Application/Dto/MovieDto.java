package com.ticketbooking.Ticket.Booking.Application.Dto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Ticket;
import lombok.*;

import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long movieId;
    private String mName;
    private Date releaseDate;
    private String director;
    private String producer;
    private String actors;
    private double budget;
    private int duration;
    private double rating;
}