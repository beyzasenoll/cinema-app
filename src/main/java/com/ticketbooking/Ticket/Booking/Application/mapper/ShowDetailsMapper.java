package com.ticketbooking.Ticket.Booking.Application.mapper;

import com.ticketbooking.Ticket.Booking.Application.Dto.ShowDetailsDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.ShowDetails;

public class ShowDetailsMapper {
    public static ShowDetailsDto toDto(ShowDetails show) {
        if (show == null) return null;
        return new ShowDetailsDto(
                show.getShowDetailsId(),
                show.getDate(),
                show.getStTime(),
                show.getEndTime(),
                show.getLang()
        );
    }

    public static ShowDetails toEntity(ShowDetailsDto showDetailsDto) {
        if (showDetailsDto == null) return null;
        ShowDetails show = new ShowDetails();
        show.setShowDetailsId(showDetailsDto.getShowDetailsId());
        show.setDate(showDetailsDto.getDate());
        show.setStTime(showDetailsDto.getStTime());
        show.setEndTime(showDetailsDto.getEndTime());
        show.setLang(showDetailsDto.getLang());
        return show;
    }
}