package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.ShowDetailsDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.ShowDetails;
import com.ticketbooking.Ticket.Booking.Application.Repository.ShowDetailsRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.ShowDetailsMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowDetailsRepository showDetailsRepository;

    public ShowDetailsDto create(ShowDetailsDto showDetailsDto) {
        ShowDetails show = ShowDetailsMapper.toEntity(showDetailsDto);
        show = showDetailsRepository.save(show);
        return ShowDetailsMapper.toDto(show);
    }

    public ShowDetailsDto findById(Long id) {
        ShowDetails show = showDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ShowData not found"));
        return ShowDetailsMapper.toDto(show);
    }

    public ShowDetailsDto update(Long id, ShowDetailsDto showDetailsDto) {
        ShowDetails show = showDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ShowData not found"));
        show.setStTime(showDetailsDto.getStTime());
        show.setEndTime(showDetailsDto.getEndTime());
        show.setLang(showDetailsDto.getLang());
        show = showDetailsRepository.save(show);
        return ShowDetailsMapper.toDto(show);
    }

    public void delete(Long id) {
        showDetailsRepository.deleteById(id);
    }
}

