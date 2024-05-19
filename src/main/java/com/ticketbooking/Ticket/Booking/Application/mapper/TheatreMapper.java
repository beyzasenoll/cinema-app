package com.ticketbooking.Ticket.Booking.Application.mapper;


import com.ticketbooking.Ticket.Booking.Application.Dto.TheatreDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Theatre;

import java.util.stream.Collectors;

// TheatreMapper.java
public class TheatreMapper {
    public static TheatreDto toDto(Theatre theatre) {
        if (theatre == null) return null;
        return new TheatreDto(
                theatre.getTid(),
                theatre.getLoc(),
                theatre.getTname(),
                theatre.getSeats().stream().map(SeatMapper::toDto).collect(Collectors.toSet()),
                theatre.getTickets().stream().map(TicketMapper::toDto).collect(Collectors.toSet())
        );
    }

    public static Theatre toEntity(TheatreDto theatreDto) {
        if (theatreDto == null) return null;
        Theatre theatre = new Theatre();
        theatre.setTid(theatreDto.getTid());
        theatre.setLoc(theatreDto.getLoc());
        theatre.setTname(theatreDto.getTname());
        theatre.setSeats(theatreDto.getSeats().stream().map(SeatMapper::toEntity).collect(Collectors.toSet()));
        theatre.setTickets(theatreDto.getTickets().stream().map(TicketMapper::toEntity).collect(Collectors.toSet()));
        return theatre;
    }
}
