package com.leultewolde.finalexam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private LocalDate orderDate;
    private CustomerResponseDTO customer;
    private List<ProductResponseDTO> products = new ArrayList<>();
}
