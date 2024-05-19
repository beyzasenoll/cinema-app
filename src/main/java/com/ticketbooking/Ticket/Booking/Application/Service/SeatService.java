package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.SeatDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Seat;
import com.ticketbooking.Ticket.Booking.Application.Repository.SeatRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.SeatMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public SeatDto create(SeatDto seatDto) {
        Seat seat = SeatMapper.toEntity(seatDto);
        seat = seatRepository.save(seat);
        return SeatMapper.toDto(seat);
    }

    public SeatDto findById(Long id) {
        Seat seat = seatRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seat not found"));
        return SeatMapper.toDto(seat);
    }

    public SeatDto update(Long id, SeatDto seatDto) {
        Seat seat = seatRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seat not found"));
        seat.setSeatType(seatDto.getSeatType());
        seat = seatRepository.save(seat);
        return SeatMapper.toDto(seat);
    }

    public void delete(Long id) {
        seatRepository.deleteById(id);
    }
}

