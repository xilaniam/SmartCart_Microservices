package com.sc.customerservice.mapper;

import com.sc.customerservice.dto.CustomerRequestDTO;
import com.sc.customerservice.dto.CustomerResponseDTO;
import com.sc.customerservice.model.Customer;

import java.time.LocalDate;

public class CustomerMapper {
    public static CustomerResponseDTO toDto(Customer customer){
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId().toString());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    public static Customer toModel(CustomerRequestDTO dto){
        Customer c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setCreatedAt(LocalDate.parse(dto.getCreatedAt()));
        return c;
    }
}
