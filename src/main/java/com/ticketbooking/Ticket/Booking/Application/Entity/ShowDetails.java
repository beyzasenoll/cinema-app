package com.ticketbooking.Ticket.Booking.Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "ticket")
@EqualsAndHashCode(exclude = "ticket")
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