package com.ticketbooking.Ticket.Booking.Application.Controller;

import com.ticketbooking.Ticket.Booking.Application.Dto.MovieDto;
import com.ticketbooking.Ticket.Booking.Application.Service.MovieDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieDataService movieDataService;

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody MovieDto movieDto) {
        MovieDto createdMovie = movieDataService.create(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        MovieDto movieDto = movieDataService.findById(id);
        return ResponseEntity.ok(movieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        MovieDto updatedMovie = movieDataService.update(id, movieDto);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieDataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

