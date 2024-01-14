package com.back.back.rest;

import com.back.back.model.Account;
import com.back.back.model.Category;
import com.back.back.model.Transaction;
import com.back.back.repository.CategoryRepository;
import com.back.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    
   ApiResponse apiResponse = new ApiResponse();

    @GetMapping("/{id}")
    Optional<Category> getCategoryById(@PathVariable("id") Long id){
        return categoryRepository.findById(id); 
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDTO categoryDTO) {
        Optional<Category> categoryOpt = categoryRepository.findAccountBydescription(categoryDTO.getDescription());
        
        if(categoryOpt.isEmpty()){
            Category category = new Category(
                categoryDTO.getDescription()
            );

            categoryRepository.save(category);
            apiResponse.setSuccess("Created with sucess.");
            return ResponseEntity.ok(apiResponse);
        }else {
            apiResponse.setBadRequest("Email already registered.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
    }
}
