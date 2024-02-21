package com.back.back.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Account;
import com.back.back.repository.AccountRepository;
import com.back.reponse.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {
   @Autowired
   AccountRepository accountRepository;
   ApiResponse apiResponse = new ApiResponse();

   @GetMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestHeader HttpHeaders headers) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        
        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic")) {
            String credentials = authorizationHeader.substring("Basic ".length()).trim();
            
            String decodedCredentials = new String(java.util.Base64.getUrlDecoder().decode(credentials));

            String[] userAndPassword = decodedCredentials.split(":");
            String mailFromHeader = userAndPassword[0];
            String passwordFromHeader = userAndPassword[1];

<<<<<<< Updated upstream
=======
            messageDigest.update(passwordFromHeader.getBytes());
            passwordFromHeader = new String(messageDigest.digest());

>>>>>>> Stashed changes
            Optional<Account> optionalAccount = accountRepository.findByMailAndPassword(mailFromHeader, passwordFromHeader);
            if (optionalAccount.isPresent()) {
                Map<String, String> response = Collections.singletonMap("status", "success");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }

        Map<String, String> response = Collections.singletonMap("status", "error");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

   @GetMapping("/{id}")
   Optional<Account> getAccountById(@PathVariable("id") Long id){
    return accountRepository.findById(id); 
   }

   @GetMapping("/user-info/{mail}")
   Optional<Account> getAccountById(@PathVariable("mail") String mail){
    return accountRepository.findByMail(mail); 
   }

   @GetMapping("/byMailAndPassword")
   Optional<Account> getAccountByMailAndPassword(@RequestBody AccountDTO accountDTO){
    return accountRepository.findAccountByMailAndPassword(accountDTO.getMail(), accountDTO.getPassword());
   }

   @GetMapping("/me")
   Optional<Account> getUserByIdAndPassword(@PathVariable String me){
        String credentials[] = new String[2];
       credentials = me.split(":");
       return accountRepository.findAccountByMailAndPassword(credentials[0], credentials[1]);
   }

   @PostMapping()
   public ResponseEntity<ApiResponse> addAccount(@RequestBody AccountDTO accountDTO){
        Optional<Account> accountOpt = accountRepository.findAccountByMail(accountDTO.getMail());
        
        if(accountOpt.isEmpty()){
            Account account = new Account(
                accountDTO.getUsername(),
                accountDTO.getMail(),
                accountDTO.getPassword(),
                accountDTO.getFullName(),
                accountDTO.getDocumentNumber(),
                accountDTO.getAddress()
            );

            accountRepository.save(account);
            apiResponse.setSuccess("Created with sucess.");
            return ResponseEntity.ok(apiResponse);
        }else {
            apiResponse.setBadRequest("Email already registered.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
   }

   @GetMapping("/login/{mail}/{password}")
    Optional<Account> getAccountById(@PathVariable("mail") String mail, @PathVariable("password") String password){
        return accountRepository.findByMailAndPassword(mail, password);
    }

    @GetMapping("/allInputs/{mail}")
    Optional<Integer> getAllInputsByMail(@PathVariable("mail") String mail){
        return accountRepository.findAllInputsByMail(mail);
    }

}
