package com.ticketbooking.Ticket.Booking.Application.mapper;


import com.ticketbooking.Ticket.Booking.Application.Dto.HallDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Hall;

import java.util.stream.Collectors;

public class HallMapper {
    public static HallDto toDto(Hall hall) {
        if (hall == null) return null;
        return new HallDto(
                hall.getHallId(),
                hall.getLoc(),
                hall.getName(),
                hall.getSeats().stream().map(SeatMapper::toDto).collect(Collectors.toSet()),
                hall.getTickets().stream().map(TicketMapper::toDto).collect(Collectors.toSet())
        );
    }

    public static Hall toEntity(HallDto hallDto) {
        if (hallDto == null) return null;
        Hall hall = new Hall();
        hall.setHallId(hallDto.getHallId());
        hall.setLoc(hallDto.getLoc());
        hall.setName(hallDto.getName());
        hall.setSeats(hallDto.getSeats().stream().map(SeatMapper::toEntity).collect(Collectors.toSet()));
        hall.setTickets(hallDto.getTickets().stream().map(TicketMapper::toEntity).collect(Collectors.toSet()));
        return hall;
    }
}
