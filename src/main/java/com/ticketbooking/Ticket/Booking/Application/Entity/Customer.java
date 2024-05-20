package com.ticketbooking.Ticket.Booking.Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tickets")
@EqualsAndHashCode(exclude = "tickets")public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String cName;
    private String pass;
    @Column(nullable = false, unique = true)
    private String email;
    private String phoneNo;

    @OneToMany(mappedBy="customer")
    Set<Ticket> tickets;

}
