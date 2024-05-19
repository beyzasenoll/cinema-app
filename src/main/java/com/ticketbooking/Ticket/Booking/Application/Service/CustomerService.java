package com.ticketbooking.Ticket.Booking.Application.Service;

import com.ticketbooking.Ticket.Booking.Application.Dto.CustomerDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Customer;
import com.ticketbooking.Ticket.Booking.Application.Repository.CustomerRepository;
import com.ticketbooking.Ticket.Booking.Application.mapper.CustomerMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

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
