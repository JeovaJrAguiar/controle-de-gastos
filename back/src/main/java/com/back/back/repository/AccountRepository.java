package com.back.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.back.back.model.Account;
import com.back.back.model.Card;
import com.back.reponse.ApiResponse;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findById(Long accountId);
    
    @Query(value = "select * from Account where username = :username", nativeQuery = true)
    Optional<Account> findAccountByUsername(@Param("username") String username);

    @Query(value = "select * from account where mail = :mail", nativeQuery = true)
    Optional<Account> findAccountByMail(@Param("mail") String mail);

    @Query(value = "select * from account where mail = :mail and password = :password", nativeQuery = true)
    Optional<Account> findAccountByMailAndPassword(String mail, String password);

    @Query(value = "select * from account where mail = :mail and password = :password", nativeQuery = true)
    Optional<Account> findByMailAndPassword(String mail, String password);

    @Query(value = "select * from account where mail = :mail", nativeQuery = true)
    Optional<Account> findByMail(String mail);

    Optional<Integer> findAllInputsByMail(String mail);
    
    /*
    @Modifying
    @Transactional
    @Query("update Account a set a.cards = :newCards WHERE a.id = :accountId")
    void updateCardsByAccountId(@Param("accountId") Long accountId, @Param("newCards") List<Card> newCards);
    
    @Query(value = "select * from user_account where mail != :mail", nativeQuery = true)
    ArrayList<UserAccount> findUsersExceptByMail(String mail);

    @Query(value = "select * from user_account where username like :username%", nativeQuery = true)
    ArrayList<UserAccount> findUsersByUsername(String username);
    */
}
