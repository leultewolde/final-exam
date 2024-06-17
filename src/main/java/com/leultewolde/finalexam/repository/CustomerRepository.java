package com.leultewolde.finalexam.repository;

import com.leultewolde.finalexam.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
