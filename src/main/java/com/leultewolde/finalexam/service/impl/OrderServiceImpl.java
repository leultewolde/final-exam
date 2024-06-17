package com.leultewolde.finalexam.service.impl;

import com.leultewolde.finalexam.dto.request.OrderRequestDTO;
import com.leultewolde.finalexam.dto.response.OrderResponseDTO;
import com.leultewolde.finalexam.dto.response.ProductResponseDTO;
import com.leultewolde.finalexam.model.Order;
import com.leultewolde.finalexam.model.Product;
import com.leultewolde.finalexam.repository.OrderRepository;
import com.leultewolde.finalexam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO) {
        Order newOrder = modelMapper.map(orderRequestDTO, Order.class);
        newOrder.setProducts(orderRequestDTO.getProductIds().stream().map(prodId -> {
            Product product = new Product();
            product.setProductId(prodId);
            return product;
        }).toList());
        Order savedOrder = orderRepository.save(newOrder);

        OrderResponseDTO responseDTO = modelMapper.map(savedOrder, OrderResponseDTO.class);
        responseDTO.setProducts(savedOrder.getProducts().stream().map(product -> modelMapper.map(product, ProductResponseDTO.class)).toList());
        return Optional.of(responseDTO);
    }

    @Override
    public Optional<OrderResponseDTO> getOrderByCustomerID(Long customerID) {
        Optional<Order> optionalFoundOrder = orderRepository.findOrdersByCustomer_CustomerId(customerID);
        if (optionalFoundOrder.isPresent()) {
            Order foundOrder = optionalFoundOrder.get();
            OrderResponseDTO responseDTO = modelMapper.map(foundOrder, OrderResponseDTO.class);
            responseDTO.setProducts(foundOrder.getProducts().stream().map(product -> modelMapper.map(product, ProductResponseDTO.class)).toList());
            return Optional.of(responseDTO);
        }
        return Optional.empty();
    }
}
