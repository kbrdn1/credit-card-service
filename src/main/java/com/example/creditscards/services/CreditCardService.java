package com.example.creditscards.services;

import com.example.creditscards.entities.CreditCard;
import com.example.creditscards.models.DebitMode;
import com.example.creditscards.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public void blockCard(Long id, Date date) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        optionalCreditCard.ifPresent(creditCard -> {
            creditCard.block(date);
            creditCardRepository.save(creditCard);
        });
    }

    public void unblockCard(Long id) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        optionalCreditCard.ifPresent(creditCard -> {
            creditCard.block(null); // unblocking by setting blocked date to null
            creditCardRepository.save(creditCard);
        });
    }

    public void updatePaymentLimit(Long id, double limit) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        optionalCreditCard.ifPresent(creditCard -> {
            creditCard.setPaymentLimit(limit);
            creditCardRepository.save(creditCard);
        });
    }

    public void updateWithdrawLimit(Long id, double limit) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        optionalCreditCard.ifPresent(creditCard -> {
            creditCard.setWithdrawLimit(limit);
            creditCardRepository.save(creditCard);
        });
    }

    public void updateDebitMode(Long id, DebitMode mode) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        optionalCreditCard.ifPresent(creditCard -> {
            creditCard.setDebitMode(mode);
            creditCardRepository.save(creditCard);
        });
    }
}
