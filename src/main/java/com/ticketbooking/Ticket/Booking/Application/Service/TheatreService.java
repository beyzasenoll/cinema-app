package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.TheatreDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Theatre;
import com.ticketbooking.Ticket.Booking.Application.Repository.TheatreRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.TheatreMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public TheatreDto create(TheatreDto theatreDto) {
        Theatre theatre = TheatreMapper.toEntity(theatreDto);
        theatre = theatreRepository.save(theatre);
        return TheatreMapper.toDto(theatre);
    }

    public TheatreDto findById(Long id) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theatre not found"));
        return TheatreMapper.toDto(theatre);
    }

    public TheatreDto update(Long id, TheatreDto theatreDto) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theatre not found"));
        theatre.setLoc(theatreDto.getLoc());
        theatre.setTname(theatreDto.getTname());
        theatre = theatreRepository.save(theatre);
        return TheatreMapper.toDto(theatre);
    }

    public void delete(Long id) {
        theatreRepository.deleteById(id);
    }
}

