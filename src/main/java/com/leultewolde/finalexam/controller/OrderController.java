package com.leultewolde.finalexam.controller;

import com.leultewolde.finalexam.dto.request.OrderRequestDTO;
import com.leultewolde.finalexam.dto.response.OrderResponseDTO;
import com.leultewolde.finalexam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Optional<OrderResponseDTO> responseDTO = orderService.createOrder(orderRequestDTO);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrderByCustomerId(
            @PathVariable Long customerId,
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam String direction,
            @RequestParam String sortBy
    ) {
        Page<OrderResponseDTO> responseDTO = orderService.getOrdersByCustomerID(customerId, pageNo, pageSize, direction, sortBy);
        return ResponseEntity.ok(responseDTO.getContent());
    }
}
