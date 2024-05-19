package com.ticketbooking.Ticket.Booking.Application.mapper;

import com.ticketbooking.Ticket.Booking.Application.Dto.MovieDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Movie;


public class MovieMapper {

    public static MovieDto toDto(Movie movieData) {
        if (movieData == null) {
            return null;
        }
        return new MovieDto(
                movieData.getMovieId(),
                movieData.getMName(),
                movieData.getReleaseDate(),
                movieData.getDirector(),
                movieData.getProducer(),
                movieData.getActors(),
                movieData.getBudget(),
                movieData.getDuration(),
                movieData.getRating(),
                movieData.getMovieTicket()
        );
    }

    public static Movie toEntity(MovieDto movieDto) {
        if (movieDto == null) {
            return null;
        }
        Movie movieData = new Movie();
        movieData.setMovieId(movieDto.getMovieId());
        movieData.setMName(movieDto.getMName());
        movieData.setReleaseDate(movieDto.getReleaseDate());
        movieData.setDirector(movieDto.getDirector());
        movieData.setProducer(movieDto.getProducer());
        movieData.setActors(movieDto.getActors());
        movieData.setBudget(movieDto.getBudget());
        movieData.setDuration(movieDto.getDuration());
        movieData.setRating(movieDto.getRating());
        movieData.setMovieTicket(movieDto.getTickets());
        return movieData;
    }
}