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
                hall.getName()
        );
    }

    public static Hall toEntity(HallDto hallDto) {
        if (hallDto == null) return null;
        Hall hall = new Hall();
        hall.setHallId(hallDto.getHallId());
        hall.setLoc(hallDto.getLoc());
        hall.setName(hallDto.getName());
        return hall;
    }
}
