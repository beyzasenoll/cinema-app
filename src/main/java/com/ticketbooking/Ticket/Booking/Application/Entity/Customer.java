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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String cName;
    private String pass;
    private String email;
    private String phoneNo;

    @OneToMany(mappedBy="customer")
    Set<Ticket> tickets;

}
