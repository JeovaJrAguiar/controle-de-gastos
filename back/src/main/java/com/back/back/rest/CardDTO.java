package com.back.back.rest;

import com.back.back.model.Account;
import com.back.back.model.Card;
import com.back.back.model.FlagEnum;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CardDTO {
    private Long id;
    private Double cardNumber;
    private FlagEnum flag;
    private Double dayClose;
    private Boolean isDebit;
    private Boolean isCredit;
    private Double limit;
    private Long account;
    
    public CardDTO() {
    }
    public CardDTO(Long id, Double cardNumber, Short flag, Double dayClose, Boolean isDebit, Boolean isCredit,
            Double limit, Long account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.flag = FlagEnum.fromValue(flag);
        this.dayClose = dayClose;
        this.isDebit = isDebit;
        this.isCredit = isCredit;
        this.limit = limit;
        this.account = account;
    }

    public static CardDTO fromCard(Card card) {
        return new CardDTO(
            card.getId(), 
            card.getCardNumber(), 
            card.getFlag(),
            card.getDayClose(), 
            card.getIsDebit(), 
            card.getIsCredit(), 
            card.getCreditLimit(), 
            card.getAccountId()
        );
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Double cardNumber) {
        this.cardNumber = cardNumber;
    }
    public FlagEnum getFlag() {
        return flag;
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
    public Boolean getIsDebit() {
        return isDebit;
    }
    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }
    public Boolean getIsCredit() {
        return isCredit;
    }
    public void setIsCredit(Boolean isCredit) {
        this.isCredit = isCredit;
    }
    public Double getLimit() {
        return limit;
    }
    public void setLimit(Double limit) {
        this.limit = limit;
    }
    public Long getAccount() {
        return account;
    }
    public void setAccount(Long account) {
        this.account = account;
    }
}
