package com.leultewolde.finalexam.service;

import com.leultewolde.finalexam.dto.request.OrderRequestDTO;
import com.leultewolde.finalexam.dto.response.OrderResponseDTO;

import java.util.Optional;

public interface OrderService {
    Optional<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO);

    Optional<OrderResponseDTO> getOrderByCustomerID(Long customerID);
}
