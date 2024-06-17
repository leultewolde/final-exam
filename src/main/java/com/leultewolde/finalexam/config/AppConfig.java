package com.leultewolde.finalexam.config;

import com.leultewolde.finalexam.dto.request.OrderRequestDTO;
import com.leultewolde.finalexam.dto.response.OrderResponseDTO;
import com.leultewolde.finalexam.dto.response.ProductResponseDTO;
import com.leultewolde.finalexam.model.Order;
import com.leultewolde.finalexam.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // OrderRequestDTO to Order
        mapper.addMappings(new PropertyMap<OrderRequestDTO, Order>() {
            @Override
            protected void configure() {
                map().getCustomer().setCustomerId(source.getCustomerId());
            }
        });

        mapper.addMappings(new PropertyMap<Order, OrderResponseDTO>() {
            @Override
            protected void configure() {
                map().getCustomer().setName(source.getCustomer().getName());
            }
        });

        return mapper;
    }

}
