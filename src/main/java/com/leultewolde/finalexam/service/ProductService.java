package com.leultewolde.finalexam.service;

import com.leultewolde.finalexam.dto.request.ProductRequestDTO;
import com.leultewolde.finalexam.dto.response.ProductResponseDTO;

import java.util.Optional;

public interface ProductService {
    Optional<ProductResponseDTO> createProduct(ProductRequestDTO productRequestDTO);

    Optional<ProductResponseDTO> getProductById(Long productId);
}
