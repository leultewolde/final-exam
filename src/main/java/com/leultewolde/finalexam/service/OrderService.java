package com.leultewolde.finalexam.service;

import com.leultewolde.finalexam.dto.request.OrderRequestDTO;
import com.leultewolde.finalexam.dto.response.OrderResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO);

    Page<OrderResponseDTO> getOrdersByCustomerID(Long customerID, int pageNo, int pageSize, String direction, String sortBy);
}
