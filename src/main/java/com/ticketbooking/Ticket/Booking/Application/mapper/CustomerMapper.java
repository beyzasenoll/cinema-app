package com.ticketbooking.Ticket.Booking.Application.mapper;

import com.ticketbooking.Ticket.Booking.Application.Dto.CustomerDto;
import com.ticketbooking.Ticket.Booking.Application.Entity.Customer;

import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        if (customer == null) return null;
        return new CustomerDto(
                customer.getCid(),
                customer.getCName(),
                customer.getEmail(),
                customer.getPhoneNo()
        );
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) return null;
        Customer customer = new Customer();
        customer.setCid(customerDto.getCid());
        customer.setCName(customerDto.getCName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNo(customerDto.getPhoneNo());
        return customer;
    }
}