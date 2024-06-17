package com.leultewolde.finalexam.service;

import com.leultewolde.finalexam.dto.request.CustomerRequestDTO;
import com.leultewolde.finalexam.dto.response.CustomerResponseDTO;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerResponseDTO> createCustomer(CustomerRequestDTO customerRequestDTO);

    Optional<CustomerResponseDTO> getCustomerByID(Long customerId);
}
