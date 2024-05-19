package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.HallDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Hall;
import com.ticketbooking.Ticket.Booking.Application.Repository.HallRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.HallMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public HallDto create(HallDto hallDto) {
        Hall hall = HallMapper.toEntity(hallDto);
        hall = hallRepository.save(hall);
        return HallMapper.toDto(hall);
    }

    public HallDto findById(Long id) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theatre not found"));
        return HallMapper.toDto(hall);
    }

    public HallDto update(Long id, HallDto hallDto) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theatre not found"));
        hall.setLoc(hallDto.getLoc());
        hall.setName(hallDto.getName());
        hall = hallRepository.save(hall);
        return HallMapper.toDto(hall);
    }

    public void delete(Long id) {
        hallRepository.deleteById(id);
    }
}

