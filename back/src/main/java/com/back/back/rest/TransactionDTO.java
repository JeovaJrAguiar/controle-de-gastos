package com.back.back.rest;

import com.back.back.model.Category;
import com.back.back.model.MethodEnum;
import com.back.back.model.Transaction;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class TransactionDTO {
    private Long id;
    private Double value;
    private Short method;
    private String description;
    private Long categoryId;
    private Long cardId;
    
    public TransactionDTO() {
    }

    public TransactionDTO(Long id, Double value, Short method, String description, Long categoryId, Long cardId) {
        
        this.id = id;
        this.value = value;
        this.method = method;
        this.description = description;
        this.categoryId = categoryId;
        this.cardId = cardId;
    }

    public static TransactionDTO fromTransaction(Transaction transaction) {
        return new TransactionDTO(
            transaction.getId(), 
            transaction.getValue(), 
            transaction.getMethod(),
            transaction.getDescription(), 
            transaction.getCategory(),
            transaction.getCardId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Short getMethod() {
        return method;
    }

    public void setMethod(Short method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
