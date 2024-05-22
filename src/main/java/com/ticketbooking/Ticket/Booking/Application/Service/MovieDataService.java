package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.MovieDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Movie;
import com.ticketbooking.Ticket.Booking.Application.Repository.MovieRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.MovieMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDataService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieDto create(MovieDto movieDto) {
        Movie movieData = MovieMapper.toEntity(movieDto);
        movieData = movieRepository.save(movieData);
        return MovieMapper.toDto(movieData);
    }

    public MovieDto findById(Long id) {
        Movie movieData = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("MovieData not found"));
        return MovieMapper.toDto(movieData);
    }

    public MovieDto update(Long id, MovieDto movieDto) {
        Movie movieData = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("MovieData not found"));
        movieData.setMName(movieDto.getMName());
        movieData.setReleaseDate(movieDto.getReleaseDate());
        movieData.setDirector(movieDto.getDirector());
        movieData.setProducer(movieDto.getProducer());
        movieData.setActors(movieDto.getActors());
        movieData.setBudget(movieDto.getBudget());
        movieData.setDuration(movieDto.getDuration());
        movieData.setRating(movieDto.getRating());
        movieData = movieRepository.save(movieData);
        return MovieMapper.toDto(movieData);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
