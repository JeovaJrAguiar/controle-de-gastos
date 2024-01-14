package com.back.back.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cardNumber;
    private FlagEnum flag;
    private Double dayClose;
    private Boolean isDebit;
    private Boolean isCredit;
    private Double creditLimit;
    /*@ManyToOne
    @JoinColumn(name = "id")*/
    private Long accountId;
    private Date creationDate;
    private Date deletionDate;

    public Card() {
    }

    /*public Card(Long id, Double cardNumber, String flagString, Double dayClose, Boolean isDebit, Boolean isCredit, Double limit, Long account) {
        short flagValue = FlagEnum.fromValueString(flagString);
        FlagEnum flag = FlagEnum.fromValue(flagValue);
        // tratar o acconunt
        // nao foi tratado por conta que eu não preciso de um metodo em DTO que retorna um account
        
        this.id = id;
        this.cardNumber = cardNumber;
        this.flag = flag;
        this.dayClose = dayClose;
        this.isDebit = isDebit;
        this.isCredit = isCredit;
        this.limit = limit;
        this.account = account;
    }*/

    public Card(Double cardNumber, FlagEnum flag, Double dayClose, Boolean isDebit, Boolean isCredit, Double creditLimit, Long accountId) {
        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);

        this.cardNumber = cardNumber;
        this.flag = flag;
        this.dayClose = dayClose;
        this.isDebit = isDebit;
        this.isCredit = isCredit;
        this.creditLimit = creditLimit;
        this.accountId = accountId;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }

    public Long getId() {
        return id;
    }
    public Double getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Double cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Short getFlag() {
        return this.flag.getValue();
    }

    public void setFlag(FlagEnum flag) {
        this.flag = flag;
    }

    public Double getDayClose() {
        return dayClose;
    }

    public void setDayClose(Double dayClose) {
        this.dayClose = dayClose;
    } 

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(Boolean isCredit) {
        this.isCredit = isCredit;
    }   

    public Boolean getIsDebit() {
        return isDebit;
    }
    
    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }
    
    public Long getAccountId() {    
        return this.accountId;
    }

    public void setAccount(Long accountId) {
        this.accountId = accountId;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    public Date getDeletionDate() {
        return deletionDate;
    }
    public void setDeletionDate() {
        long millis = System.currentTimeMillis();  
        Date deletionDate =new java.sql.Date(millis);
        
        this.deletionDate = deletionDate;
    }
}
