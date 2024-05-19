package com.ticketbooking.Ticket.Booking.Application.Controller;
import com.ticketbooking.Ticket.Booking.Application.Dto.HallDto;
import com.ticketbooking.Ticket.Booking.Application.Service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/theatres")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping
    public ResponseEntity<HallDto> create(@RequestBody HallDto hallDto) {
        HallDto createdTheatre = hallService.create(hallDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheatre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallDto> findById(@PathVariable Long id) {
        HallDto hallDto = hallService.findById(id);
        return ResponseEntity.ok(hallDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HallDto> update(@PathVariable Long id, @RequestBody HallDto hallDto) {
        HallDto updatedTheatre = hallService.update(id, hallDto);
        return ResponseEntity.ok(updatedTheatre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hallService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
