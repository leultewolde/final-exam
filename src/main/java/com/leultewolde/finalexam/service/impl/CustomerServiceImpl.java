package com.leultewolde.finalexam.service.impl;

import com.leultewolde.finalexam.dto.request.CustomerRequestDTO;
import com.leultewolde.finalexam.dto.response.CustomerResponseDTO;
import com.leultewolde.finalexam.model.Customer;
import com.leultewolde.finalexam.repository.CustomerRepository;
import com.leultewolde.finalexam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<CustomerResponseDTO> createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer newCustomer = modelMapper.map(customerRequestDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(newCustomer);

        CustomerResponseDTO responseDTO = modelMapper.map(savedCustomer, CustomerResponseDTO.class);
        return Optional.of(responseDTO);
    }

    @Override
    public Optional<CustomerResponseDTO> getCustomerByID(Long customerId) {
        Optional<Customer> optionalFoundCustomer = customerRepository.findById(customerId);
        if (optionalFoundCustomer.isPresent()) {
            CustomerResponseDTO responseDTO = modelMapper.map(optionalFoundCustomer.get(), CustomerResponseDTO.class);
            return Optional.of(responseDTO);
        }
        return Optional.empty();
    }
}
