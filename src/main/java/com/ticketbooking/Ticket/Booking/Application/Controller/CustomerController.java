package com.ticketbooking.Ticket.Booking.Application.Controller;

import com.ticketbooking.Ticket.Booking.Application.Dto.CustomerDto;
import com.ticketbooking.Ticket.Booking.Application.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.create(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.findById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.update(id, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
