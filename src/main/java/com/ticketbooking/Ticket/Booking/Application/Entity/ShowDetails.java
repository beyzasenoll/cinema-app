package com.ticketbooking.Ticket.Booking.Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "showDetails")
public class ShowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showDetailsId;
    private String date;
    private String stTime;
    private String endTime;
    private String lang;
    @OneToOne(mappedBy = "showDetails")
    private Ticket ticket;

}