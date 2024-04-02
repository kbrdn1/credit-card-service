package com.example.creditscards.entities;

import com.example.creditscards.models.DebitMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private CreditCard creditCard;

    @BeforeEach
    void setUp() {
        creditCard = new CreditCard();
    }

    @Test
    void block() {
        Date blockDate = new Date();
        creditCard.block(blockDate);
        assertEquals(blockDate, creditCard.getBloquedDate());
    }

    @Test
    void setWithdrawLimit() {
        double withdrawLimit = 1000;
        creditCard.setWithdrawLimit(withdrawLimit);
        assertEquals(withdrawLimit, creditCard.getWithdrawLimit());
    }

    @Test
    void setPaymentLimit() {
        double paymentLimit = 1000;
        creditCard.setPaymentLimit(paymentLimit);
        assertEquals(paymentLimit, creditCard.getPaymentLimit());
    }


    @Test
    void setDebitMode() {
        DebitMode debitMode = DebitMode.IMMEDIATE;
        creditCard.setDebitMode(debitMode);
        assertEquals(debitMode, creditCard.getDebitMode());

    }
}