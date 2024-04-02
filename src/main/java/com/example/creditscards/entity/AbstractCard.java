package com.example.creditscards.entity;

import com.example.creditscards.model.PaymentNetwork;
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
public abstract class AbstractCard {

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
    @NonNull
    private double balance;
    @Positive
    private double withdrawLimit;
    @Positive
    private double paymentLimit;
    private Date bloquedDate;
    private Date diferredDebitDate;
    private String pinCode;
    @PositiveOrZero
    @NonNull
    private double withoutContactPaymentLimit;
    @NonNull
    private PaymentNetwork paymentNetwork;

}