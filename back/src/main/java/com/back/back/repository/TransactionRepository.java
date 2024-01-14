package com.back.back.repository;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.back.model.Account;
import com.back.back.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
    Optional<Transaction> findById(Long transactionId);
    // Optional<Category> findById(Long categoryId);

    @Query(value = "select * from transaction where card_id = :cardId and creation_date != NULL", nativeQuery = true)
    Optional<Transaction> findTransactionsByCardId(Long cardId);

    @Query(value = "select SUM(value) from transaction WHERE card_id = :cardId and category_id = 1", nativeQuery = true)
    Long sumAllInputsByMail(@Param("cardId") Long cardId);

    @Query(value = "select SUM(value) from transaction WHERE card_id = :cardId and category_id = 2", nativeQuery = true)
    Long sumAllOutputsByMail(@Param("cardId") Long cardId);

Optional<Transaction> findTransactionsById(Long cardID);

    /*@Query("SELECT COALESCE(SUM(t.value), 0) FROM Transaction t " +
           "JOIN t.card c " +
           "JOIN c.account a " +
           "WHERE a.mail = :mail AND t.category.type = 'SAIDA'")
    Long sumAllOutputsByMail(@Param("mail") String mail);

    @Query("SELECT COALESCE(SUM(t.value), 0) FROM Transaction t " + "WHERE t.cardId = :cardId")
    Long sumAllTransactionsByCardId(@Param("cardId") Long cardId);

    // Método para encontrar a soma de todas as transações de saída feitas por um Card
    @Query("SELECT COALESCE(SUM(t.value), 0) FROM Transaction t " + "WHERE t.cardId = :cardId AND t.category.type = 'SAIDA'")
    Long sumAllOutputsByCardId(@Param("cardId") Long cardId);
    */
}
