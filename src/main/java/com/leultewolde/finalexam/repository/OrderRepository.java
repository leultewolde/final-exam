package com.leultewolde.finalexam.repository;

import com.leultewolde.finalexam.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    Optional<List<Order>> findOrdersByCustomer_CustomerId(Long customerId);
    Page<Order> findOrdersByCustomer_CustomerId(Long customerId, Pageable pageable);
}
