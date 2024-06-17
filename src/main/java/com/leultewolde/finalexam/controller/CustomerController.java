package com.leultewolde.finalexam.controller;

import com.leultewolde.finalexam.dto.request.CustomerRequestDTO;
import com.leultewolde.finalexam.dto.response.CustomerResponseDTO;
import com.leultewolde.finalexam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        Optional<CustomerResponseDTO> responseDTO = customerService.createCustomer(customerRequestDTO);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long customerId) {
        Optional<CustomerResponseDTO> responseDTO = customerService.getCustomerByID(customerId);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
