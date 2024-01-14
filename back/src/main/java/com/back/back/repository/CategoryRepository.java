package com.back.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.back.back.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
    Optional<Category> findById(Long categoryId);

    @Query(value = "select * from category", nativeQuery = true)
    Optional<Category> findAllCategories();

    @Query(value = "select * from category where description = :description ", nativeQuery = true)
    Optional<Category> findAccountBydescription(String description);

    
}
