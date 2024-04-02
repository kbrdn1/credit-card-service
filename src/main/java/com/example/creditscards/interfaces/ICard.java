package com.example.creditscards.interfaces;


import com.example.creditscards.models.DebitMode;

import java.util.Date;

public interface ICard {
    void block(Date date);
    void setWithdrawLimit(double amount);
    double getWithdrawLimit();
    void setPaymentLimit(double amount);
    double getPaymentLimit();
    void setDebitMode(DebitMode amount);
    DebitMode getDebitMode();
}