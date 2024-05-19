package com.ticketbooking.Ticket.Booking.Application.Controller;
import com.ticketbooking.Ticket.Booking.Application.Dto.TheatreDto;
import com.ticketbooking.Ticket.Booking.Application.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<TheatreDto> create(@RequestBody TheatreDto theatreDto) {
        TheatreDto createdTheatre = theatreService.create(theatreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheatre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreDto> findById(@PathVariable Long id) {
        TheatreDto theatreDto = theatreService.findById(id);
        return ResponseEntity.ok(theatreDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheatreDto> update(@PathVariable Long id, @RequestBody TheatreDto theatreDto) {
        TheatreDto updatedTheatre = theatreService.update(id, theatreDto);
        return ResponseEntity.ok(updatedTheatre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        theatreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
