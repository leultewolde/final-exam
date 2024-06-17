package com.leultewolde.finalexam.controller;

import com.google.gson.Gson;
import com.leultewolde.finalexam.dto.response.CustomerResponseDTO;
import com.leultewolde.finalexam.model.Customer;
import com.leultewolde.finalexam.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getCustomerById() throws Exception {
        CustomerResponseDTO foundCustomer = new CustomerResponseDTO("leultewolde");
        Mockito.when(customerService.getCustomerByID(1L)).thenReturn(Optional.of(foundCustomer));

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(foundCustomer)));
    }
}