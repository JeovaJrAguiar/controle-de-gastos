package com.back.back.rest;

import com.back.back.model.Account;

public class AccountDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String mail;
    private Long documentNumber;
    private String address;

    public AccountDTO() {
    }

    public AccountDTO(String username, String password, String fullName, String mail, Long documentNumber,
            String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mail = mail;
        this.documentNumber = documentNumber;
        this.address = address;
    }

    public AccountDTO(Long id, String mail, String password, String username, String fullName, Long documentNumber, String address) {
        this.id = id;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
    }

    public static AccountDTO fromAccount(Account account) {
        return new AccountDTO(
            account.getId(),
            account.getMail(),
            account.getPassword(),
            account.getUsername(),
            account.getFullName(),
            account.getDocumentNumber(),
            account.getAddress()
        );
    }

    public Account toAccount() {
        return new Account( 
            this.username, 
            this.mail, 
            this.password, 
            this.fullName, 
            this.documentNumber,
            this.address
        );
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getMail() {
        return mail;
    }
    public String getFullName() {
        return fullName;
    }
    public Long getDocumentNumber() {
        return documentNumber;
    }
    public String getAddress() {
        return address;
    }
}
