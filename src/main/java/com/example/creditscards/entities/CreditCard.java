package com.example.creditscards.entities;

import com.example.creditscards.interfaces.ICard;
import com.example.creditscards.models.DebitMode;
import com.example.creditscards.models.PaymentNetwork;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.NonNull;

import java.util.Date;

@Entity
public class CreditCard implements ICard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NonNull
    private String number;

    @NotBlank
    @NonNull
    private String lastname;

    @NotBlank
    @NonNull
    private String firstname;

    @NonNull
    private Date expirationDate;

    @NotBlank
    @NonNull
    private String cvv;

    @Positive
    private double withdrawLimit;

    @Positive
    private double paymentLimit;

    private Date bloquedDate;

    private String pinCode;

    @PositiveOrZero
    private double withoutContactPaymentLimit;

    @NonNull
    private PaymentNetwork paymentNetwork;

    @NonNull
    private DebitMode debitMode;

    @Override
    public void block(Date date) {
        this.bloquedDate = date;
    }

    @Override
    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    @Override
    public void setPaymentLimit(double paymentLimit) {
        this.paymentLimit = paymentLimit;
    }

    @Override
    public double getPaymentLimit() {
        return paymentLimit;
    }

    @Override
    public void setDebitMode(@NonNull DebitMode debitMode) {
        this.debitMode = debitMode;
    }

    @Override
    public @NonNull DebitMode getDebitMode() {
        return this.debitMode;
    }
}
