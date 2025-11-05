package com.sc.customerservice.controller;

import com.sc.customerservice.dto.CustomerRequestDTO;
import com.sc.customerservice.dto.CustomerResponseDTO;
import com.sc.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getCustomers(){
        List<CustomerResponseDTO> dtos = customerService.getCustomers();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO){
        CustomerResponseDTO dto = customerService.createCustomer(requestDTO);
        return ResponseEntity.ok().body(dto);
    }

}
