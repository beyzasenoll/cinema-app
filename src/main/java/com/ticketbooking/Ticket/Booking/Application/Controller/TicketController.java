package com.ticketbooking.Ticket.Booking.Application.Controller;

import com.ticketbooking.Ticket.Booking.Application.Dto.TicketDto;
import com.ticketbooking.Ticket.Booking.Application.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticketDto) {
        TicketDto createdTicket = ticketService.create(ticketDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> findById(@PathVariable Long id) {
        TicketDto ticketDto = ticketService.findById(id);
        return ResponseEntity.ok(ticketDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> update(@PathVariable Long id, @RequestBody TicketDto ticketDto) {
        TicketDto updatedTicket = ticketService.update(id, ticketDto);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

