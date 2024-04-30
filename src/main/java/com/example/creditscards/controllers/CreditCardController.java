package com.example.creditscards.controllers;


import com.example.creditscards.component.TokenService;
import com.example.creditscards.entities.CreditCard;
import com.example.creditscards.models.DebitMode;
import com.example.creditscards.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCards(@RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(creditCardService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard, @RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        CreditCard createdCard = creditCardService.createCreditCard(creditCard);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<String> blockCard(@PathVariable Long id,@RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return ResponseEntity.status(401).body("Unauthorized.");

        creditCardService.blockCard(id, new Date());
        return ResponseEntity.ok("Card blocked successfully.");
    }

    @PutMapping("/{id}/unblock")
    public ResponseEntity<String> unblockCard(@PathVariable Long id, @RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return ResponseEntity.status(401).body("Unauthorized.");

        creditCardService.unblockCard(id);
        return ResponseEntity.ok("Card unblocked successfully.");
    }

    @PutMapping("/{id}/payment-limit")
    public ResponseEntity<String> updatePaymentLimit(@PathVariable Long id, @RequestParam double limit, @RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return ResponseEntity.status(401).body("Unauthorized.");

        creditCardService.updatePaymentLimit(id, limit);
        return ResponseEntity.ok("Payment limit updated successfully.");
    }

    @PutMapping("/{id}/withdraw-limit")
    public ResponseEntity<String> updateWithdrawLimit(@PathVariable Long id, @RequestParam double limit, @RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return ResponseEntity.status(401).body("Unauthorized.");

        creditCardService.updateWithdrawLimit(id, limit);
        return ResponseEntity.ok("Withdraw limit updated successfully.");
    }

    @PutMapping("/{id}/debit-mode")
    public ResponseEntity<String> updateDebitMode(@PathVariable Long id, @RequestParam DebitMode mode, @RequestHeader (name="Authorization") String token) {
        if(!tokenService.checkTokenIsValid(token))
            return ResponseEntity.status(401).body("Unauthorized.");

        creditCardService.updateDebitMode(id, mode);
        return ResponseEntity.ok("Debit mode updated successfully.");
    }
}
