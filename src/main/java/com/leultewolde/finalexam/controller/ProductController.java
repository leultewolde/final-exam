package com.leultewolde.finalexam.controller;

import com.leultewolde.finalexam.dto.request.ProductRequestDTO;
import com.leultewolde.finalexam.dto.response.ProductResponseDTO;
import com.leultewolde.finalexam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Optional<ProductResponseDTO> responseDTO = productService.createProduct(productRequestDTO);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId) {
        Optional<ProductResponseDTO> responseDTO = productService.getProductById(productId);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
