package com.example.creditscards.interfaces;

import com.example.creditscards.model.PaymentNetwork;


import java.util.Date;

public interface ICard {
    double credit(double amount);
    double debit(double amount);
    void block(Date date);
    void setWithdrawLimit(double amount);
    double getWithdrawLimit();
    void setPaymentLimit(double amount);
    double getPaymentLimit();
}