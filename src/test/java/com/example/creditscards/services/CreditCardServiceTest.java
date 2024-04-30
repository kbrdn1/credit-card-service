package com.example.creditscards.services;

import com.example.creditscards.entities.CreditCard;
import com.example.creditscards.models.DebitMode;
import com.example.creditscards.models.PaymentNetwork;
import com.example.creditscards.repositories.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreditCardServiceTest {
    private CreditCardRepository creditCardRepository;
    private CreditCardService creditCardService;
    private CreditCard creditCard;
    private List<CreditCard> creditCardList;
    private PaymentNetwork paymentNetwork;
    private DebitMode debitMode;
    private Date date;
    private double amount;

    @BeforeEach
    public void setUp() {
        creditCardRepository = mock(CreditCardRepository.class);
        creditCardService = new CreditCardService(creditCardRepository);
        paymentNetwork = PaymentNetwork.VISA;
        debitMode = DebitMode.IMMEDIATE;
        date = new Date();
        amount = 1000;
        creditCard = new CreditCard();
        creditCard.setPaymentLimit(amount);
        creditCard.setWithdrawLimit(amount);
        creditCard.setDebitMode(debitMode);
        creditCard.setPaymentNetwork(paymentNetwork);
        creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
    }

    @Test
    public void testGetAllCreditCards() {
        when(creditCardRepository.findAll()).thenReturn(creditCardList);
        List<CreditCard> creditCards = creditCardService.getAll();
        assertEquals(creditCardList, creditCards);
    }

    @Test
    public void testBlockCard() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        creditCardService.blockCard(1L, date);
        assertEquals(date, creditCard.getBloquedDate());
    }

    @Test
    public void testUnblockCard() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        creditCardService.unblockCard(1L);
        assertEquals(null, creditCard.getBloquedDate());
    }

    @Test
    public void testUpdatePaymentLimit() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        creditCardService.updatePaymentLimit(1L, 0);
        assertEquals(0, creditCard.getPaymentLimit());
    }

    @Test
    public void testUpdateWithdrawLimit() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        creditCardService.updateWithdrawLimit(1L, 0);
        assertEquals(0, creditCard.getWithdrawLimit());
    }

    @Test
    public void testUpdateDebitMode() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        creditCardService.updateDebitMode(1L, DebitMode.DEFERRED);
        assertEquals(DebitMode.DEFERRED, creditCard.getDebitMode());
    }

    @Test void testGetCreditCardById() {
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        CreditCard card = creditCardService.getCreditCardById(1L);
        assertEquals(creditCard, card);
    }
}
