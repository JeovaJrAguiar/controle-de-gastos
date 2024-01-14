package com.back.back.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Account;
import com.back.back.model.Card;
import com.back.back.repository.AccountRepository;
import com.back.back.repository.CardRepository;
import com.back.reponse.ApiResponse;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardRepository cardRepository;

    AccountRepository accountRepository;

    @GetMapping("/{id}")
    Optional<Card> getCardById(@PathVariable("id") Long id){
        return cardRepository.findById(id);
    }

    
    /*@GetMapping("/{id}")
   Optional<Account> getAccountById(@PathVariable("id") Long id){
    return accountRepository.findById(id);
   }*/

    @PostMapping()
    public ResponseEntity<ApiResponse> addCard(@RequestBody CardDTO cardDTO){
        Optional<Card> cardOpt = cardRepository.findCardByNumber(cardDTO.getCardNumber());
        
        ApiResponse apiResponse = new ApiResponse();

        if(cardOpt.isEmpty()){
            Card card = new Card(
                cardDTO.getCardNumber(),
                cardDTO.getFlag(),
                cardDTO.getDayClose(),
                cardDTO.getIsDebit(),
                cardDTO.getIsCredit(),
                cardDTO.getLimit(),
                cardDTO.getAccount()
            );

            cardRepository.save(card);
            apiResponse.setSuccess("Created with sucess." + " Id: " + card.getId());
            return ResponseEntity.ok(apiResponse);
        }else {
            apiResponse.setBadRequest("Card number already registered.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }

    }
}
