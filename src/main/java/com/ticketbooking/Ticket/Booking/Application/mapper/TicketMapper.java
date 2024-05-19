package com.ticketbooking.Ticket.Booking.Application.mapper;

import com.ticketbooking.Ticket.Booking.Application.Dto.TicketDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Ticket;

import java.util.stream.Collectors;

public class TicketMapper {
    public static TicketDto toDto(Ticket ticket) {
        if (ticket == null) return null;
        return new TicketDto(
                ticket.getTicketNo(),
                ticket.getHallNo(),
                ticket.getPrice(),
                ticket.getSeatNo(),
                CustomerMapper.toDto(ticket.getCustomer()),
                ShowDetailsMapper.toDto(ticket.getShowDetails()),
                TheatreMapper.toDto(ticket.getTheatre()),
                ticket.getMovies().stream()
                        .map(MovieMapper::toDto)
                        .collect(Collectors.toSet())
        );
    }

    public static Ticket toEntity(TicketDto ticketDto) {
        if (ticketDto == null) return null;
        Ticket ticket = new Ticket();
        ticket.setTicketNo(ticketDto.getTicketNo());
        ticket.setHallNo(ticketDto.getHallNo());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setSeatNo(ticketDto.getSeatNo());
        ticket.setCustomer(CustomerMapper.toEntity(ticketDto.getCustomer()));
        ticket.setShowDetails(ShowDetailsMapper.toEntity(ticketDto.getShowData()));
        ticket.setTheatre(TheatreMapper.toEntity(ticketDto.getTheatre()));
        ticket.setMovies(ticketDto.getMovies().stream()
                .map(MovieMapper::toEntity)
                .collect(Collectors.toSet()));
        return ticket;
    }
}

