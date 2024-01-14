package com.back.back.rest;

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
import com.back.back.model.Category;
import com.back.back.model.Transaction;
import com.back.back.repository.TransactionRepository;
import com.back.reponse.ApiResponse;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepostiory;
    ApiResponse apiResponse = new ApiResponse();

    @GetMapping("/{id}")
    Optional<Transaction> getTransactionById(@PathVariable("id") Long id){
        return transactionRepostiory.findById(id);
    }

    @GetMapping("/allTransactions/{cardID}")
    Optional<Transaction> getTransactionsByCardId(@PathVariable("cardID") Long cardID){
        return transactionRepostiory.findTransactionsById(cardID);
    }

    @GetMapping("/allTransaction/inputs/{cardId}")
    Long getTransactionsInputsByCardId(@PathVariable Long cardId){
        return transactionRepostiory.sumAllInputsByMail(cardId);
    }

    @GetMapping("/allTransaction/outputs/{cardId}")
    Long getTransactionsOutputsByCardId(@PathVariable Long cardId){
        return transactionRepostiory.sumAllOutputsByMail(cardId);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Optional<Transaction> transactionOpt = transactionRepostiory.findTransactionsByCardId(transactionDTO.getCardId());
        
            if(transactionOpt.isEmpty()){
                Transaction newTransaction = new Transaction(
                    transactionDTO.getValue(),
                    transactionDTO.getMethod(),
                    transactionDTO.getDescription(),
                    transactionDTO.getCategoryId(),
                    transactionDTO.getCardId()
                );

                transactionRepostiory.save(newTransaction);
                apiResponse.setSuccess("Created with sucess.");
                return ResponseEntity.ok(apiResponse);
            } else {
                apiResponse.setBadRequest("Email already registered.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
            }
    }
}
