package com.example.creditscards.controllers;

import com.example.creditscards.entities.CreditCard;
import com.example.creditscards.repositories.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//TO-DO: Add the necessary to run this test
@SpringBootTest
@AutoConfigureMockMvc
public class CreditCardControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetAllCreditCards() throws Exception {
        mockMvc.perform(get("/getAll")).andExpect(status().isNotFound());
    }
}
