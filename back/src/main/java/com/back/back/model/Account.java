package com.back.back.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String mail;
    private String password;
    private String fullName;
    private Long documentNumber;
    private String address;
    //@OneToMany(mappedBy = "account")
    //private List<Card> cards;
    private Date creationDate;
    private Date deletionDate;

    public Account() {
    }
    
    public Account(String username, String mail, String password, String fullName, Long documentNumber,
            String address) {

        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);

        this.username = username;
        this.mail = mail;
        this.password = password;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
        //this.cards = null;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }

    public Account(String username, String mail, String password, String fullName, Long documentNumber, String address,
            List<Card> cards) {
        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);        

        this.username = username;
        this.mail = mail;
        this.password = password;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
        //this.cards = cards;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }
    
    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public Long getDocumentNumber() {
        return this.documentNumber;
    }
    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }
    
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    /*public List<Card> getCards() {
        return this.cards;
    }
    public void addCard(Card card) {
        this.cards.add(card);
        card.setAccount(this.getId());
    }
    public void setCardsByListCards(List<Card> cards) {
        this.cards = cards;
    }*/

    public Date getCreationDate() {
        return this.creationDate;
    }
    public Date getDeletionDate() {
        return this.deletionDate;
    }
    public void setDeletionDate() {
        long millis = System.currentTimeMillis();  
        Date deletionDate =new java.sql.Date(millis);
        
        this.deletionDate = deletionDate;
    }
}
