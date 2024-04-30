package com.example.creditscards.controllers;

import com.example.creditscards.entities.CreditCard;
import com.example.creditscards.models.DebitMode;
import com.example.creditscards.repositories.CreditCardRepository;
import com.example.creditscards.services.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreditCardControllerTest {
    private CreditCardController creditCardController;
    private CreditCardService creditCardService;
    private CreditCard creditCard;
    private List<CreditCard> creditCardList;
    private CreditCardRepository creditCardRepository;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditCard();
        creditCard.setDebitMode(DebitMode.DEFERRED);
        creditCard.setPaymentLimit(1000);
        creditCard.setWithdrawLimit(1000);
        creditCardList = List.of(creditCard);
        creditCardRepository = mock(CreditCardRepository.class);
        when(creditCardRepository.findAll()).thenReturn(creditCardList);
        when(creditCardRepository.findById(1L)).thenReturn(java.util.Optional.of(creditCard));
        when(creditCardRepository.save(any(CreditCard.class))).thenAnswer(i -> i.getArguments()[0]);
        creditCardService = new CreditCardService(creditCardRepository);
        creditCardController = new CreditCardController(creditCardService);
    }

    @Test
    public void testGetAllCreditCards() {
        List<CreditCard> creditCards = creditCardController.getAllCreditCards().getBody();
        assertEquals(creditCardList, creditCards);
    }

    @Test
    public void testGetCreditCardById() {
        CreditCard creditCardById = creditCardController.getCreditCardById(1L).getBody();
        assertEquals(creditCard, creditCardById);
    }

    @Test
    public void testCreateCreditCard() {
        CreditCard newCreditCard = new CreditCard();
        newCreditCard.setDebitMode(DebitMode.IMMEDIATE);
        newCreditCard.setPaymentLimit(1000);
        newCreditCard.setWithdrawLimit(1000);
        newCreditCard.setId(2L);
        CreditCard createdCard = creditCardController.createCreditCard(newCreditCard).getBody();
        assertEquals(newCreditCard, createdCard);
    }

    @Test
    public void testBlockCard() {
        creditCardController.blockCard(1L);
        CreditCard bloquedCard = creditCardController.getCreditCardById(1L).getBody();
        assertEquals(creditCard.getBloquedDate(), bloquedCard.getBloquedDate());
    }

    @Test
    public void testUnblockCard() {
        creditCardController.unblockCard(1L);
        CreditCard unbloquedCard = creditCardController.getCreditCardById(1L).getBody();
        assertEquals(null, unbloquedCard.getBloquedDate());
    }

    @Test
    public void testUpdatePaymentLimit() {
        creditCardController.updatePaymentLimit(1L, 1000);
        assertEquals(1000, creditCard.getPaymentLimit());
    }

    @Test
    public void testUpdateWithdrawLimit() {
        creditCardController.updateWithdrawLimit(1L, 1000);
        assertEquals(1000, creditCard.getWithdrawLimit());
    }

    @Test
    public void testUpdateDebitMode() {
        creditCardController.updateDebitMode(1L, DebitMode.IMMEDIATE);
        assertEquals(DebitMode.IMMEDIATE, creditCard.getDebitMode());
    }
}
