package com.leultewolde.finalexam.repository;

import com.leultewolde.finalexam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
