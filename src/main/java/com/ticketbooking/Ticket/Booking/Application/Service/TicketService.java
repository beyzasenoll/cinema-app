package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.TicketDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Ticket;
import com.ticketbooking.Ticket.Booking.Application.Repository.TicketRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDto create(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.toEntity(ticketDto);
        ticket = ticketRepository.save(ticket);
        return TicketMapper.toDto(ticket);
    }

    public TicketDto findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        return TicketMapper.toDto(ticket);
    }

    public TicketDto update(Long id, TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
        ticket.setPrice(ticketDto.getPrice());
        ticket.setSeatNo(ticketDto.getSeatNo());
        ticket.setCustomer(CustomerMapper.toEntity(ticketDto.getCustomer()));
        ticket.setShowDetails(ShowDetailsMapper.toEntity(ticketDto.getShowData()));
        ticket.setHall(HallMapper.toEntity(ticketDto.getTheatre()));
        ticket = ticketRepository.save(ticket);
        return TicketMapper.toDto(ticket);
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

}

