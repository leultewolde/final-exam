package com.leultewolde.finalexam.repository;

import com.leultewolde.finalexam.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrdersByCustomer_CustomerId(Long customerId);
}
