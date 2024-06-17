package com.leultewolde.finalexam.service.impl;

import com.leultewolde.finalexam.dto.request.ProductRequestDTO;
import com.leultewolde.finalexam.dto.response.ProductResponseDTO;
import com.leultewolde.finalexam.model.Product;
import com.leultewolde.finalexam.repository.ProductRepository;
import com.leultewolde.finalexam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ProductResponseDTO> createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = modelMapper.map(productRequestDTO, Product.class);
        Product savedProduct = productRepository.save(newProduct);

        ProductResponseDTO productResponseDTO = modelMapper.map(savedProduct, ProductResponseDTO.class);
        return Optional.of(productResponseDTO);
    }

    @Override
    public Optional<ProductResponseDTO> getProductById(Long productId) {
        Optional<Product> optionalFoundProduct = productRepository.findById(productId);
        if (optionalFoundProduct.isPresent()) {
            ProductResponseDTO productResponseDTO = modelMapper.map(optionalFoundProduct.get(), ProductResponseDTO.class);
            return Optional.of(productResponseDTO);
        }
        return Optional.empty();
    }
}
