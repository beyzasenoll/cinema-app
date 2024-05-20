package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.CustomerDto;
import com.ticketbooking.Ticket.Booking.Application.Dto.TicketDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Customer;
import com.ticketbooking.Ticket.Booking.Application.Entity.Ticket;
import com.ticketbooking.Ticket.Booking.Application.Repository.CustomerRepository;
import com.ticketbooking.Ticket.Booking.Application.Repository.TicketRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.CustomerMapper;
import com.ticketbooking.Ticket.Booking.Application.mapper.TicketMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDto selectTicket(Long customerId, Long ticketId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);

        if (customerOpt.isPresent() && ticketOpt.isPresent()) {
            Customer customer = customerOpt.get();
            Ticket ticket = ticketOpt.get();
            ticket.setCustomer(customer);
            ticketRepository.save(ticket);
            return TicketMapper.toDto(ticket);
        }

        return null;
    }

    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        customer = customerRepository.save(customer);
        return CustomerMapper.toDto(customer);
    }

    public CustomerDto findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        return CustomerMapper.toDto(customer);
    }

    public CustomerDto update(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customer.setCName(customerDto.getCName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNo(customerDto.getPhoneNo());
        customer = customerRepository.save(customer);
        return CustomerMapper.toDto(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
