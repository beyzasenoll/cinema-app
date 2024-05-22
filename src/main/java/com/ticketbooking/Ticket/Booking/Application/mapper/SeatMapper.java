package com.ticketbooking.Ticket.Booking.Application.mapper;

import com.ticketbooking.Ticket.Booking.Application.Dto.SeatDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Seat;

public class SeatMapper {
    public static SeatDto toDto(Seat seat) {
        if (seat == null) return null;
        return new SeatDto(
                seat.getSeatNo(),
                seat.getSeatType()
        );
    }

    public static Seat toEntity(SeatDto seatDto) {
        if (seatDto == null) return null;
        Seat seat = new Seat();
        seat.setSeatNo(seatDto.getSeatNo());
        seat.setSeatType(seatDto.getSeatType());
        return seat;
    }
}