package com.ticketbooking.Ticket.Booking.Application.Controller;
import com.ticketbooking.Ticket.Booking.Application.Dto.SeatDto;
import com.ticketbooking.Ticket.Booking.Application.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatDto> create(@RequestBody SeatDto seatDto) {
        SeatDto createdSeat = seatService.create(seatDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatDto> findById(@PathVariable Long id) {
        SeatDto seatDto = seatService.findById(id);
        return ResponseEntity.ok(seatDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatDto> update(@PathVariable Long id, @RequestBody SeatDto seatDto) {
        SeatDto updatedSeat = seatService.update(id, seatDto);
        return ResponseEntity.ok(updatedSeat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

