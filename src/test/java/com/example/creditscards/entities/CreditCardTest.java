package com.example.creditscards.entities;

import com.example.creditscards.models.DebitMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private CreditCard creditCard;

    @BeforeEach
    void testSetUp() {
        creditCard = new CreditCard();
    }

    @Test
    void testBlock() {
        Date blockDate = new Date();
        creditCard.block(blockDate);
        assertEquals(blockDate, creditCard.getBloquedDate());
    }

    @Test
    void testSetWithdrawLimit() {
        double withdrawLimit = 1000;
        creditCard.setWithdrawLimit(withdrawLimit);
        assertEquals(withdrawLimit, creditCard.getWithdrawLimit());
    }

    @Test
    void testSetPaymentLimit() {
        double paymentLimit = 1000;
        creditCard.setPaymentLimit(paymentLimit);
        assertEquals(paymentLimit, creditCard.getPaymentLimit());
    }


    @Test
    void testSetDebitMode() {
        DebitMode debitMode = DebitMode.IMMEDIATE;
        creditCard.setDebitMode(debitMode);
        assertEquals(debitMode, creditCard.getDebitMode());

    }
}