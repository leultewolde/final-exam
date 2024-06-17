package com.leultewolde.finalexam.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
