package com.example.creditscards.interfaces;

import com.example.creditscards.model.PaymentNetwork;


import java.util.Date;

public interface ICard {
    double credit(double amount);
    double debit(double amount);
    void block();
    void setWithdrawLimit(double amount);
    double getWithdrawLimit();
}