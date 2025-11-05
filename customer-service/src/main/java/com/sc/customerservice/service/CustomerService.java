package com.sc.customerservice.service;

import com.sc.customerservice.dto.CustomerRequestDTO;
import com.sc.customerservice.dto.CustomerResponseDTO;
import com.sc.customerservice.exception.EmailAlreadyExistsException;
import com.sc.customerservice.mapper.CustomerMapper;
import com.sc.customerservice.model.Customer;
import com.sc.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDTO> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> dtoList = customers.stream().map(customer -> CustomerMapper.toDto(customer)).toList();
        return dtoList;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO requestDTO){
        if(customerRepository.existsByEmail(requestDTO.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists : "+ requestDTO.getEmail());
        }

        Customer customer = new Customer();
        customer.setName(requestDTO.getName());
        customer.setEmail(requestDTO.getEmail());
        customer.setCreatedAt(LocalDate.parse(requestDTO.getCreatedAt()));

        customerRepository.save(customer);

        return CustomerMapper.toDto(customer);
    }
}
