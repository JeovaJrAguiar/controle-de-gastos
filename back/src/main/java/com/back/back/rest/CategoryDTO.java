package com.back.back.rest;

import com.back.back.model.Category;

public class CategoryDTO {
    private Long id;
    private String description;
    private Long transactionId;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public static CategoryDTO fromCategory(Category category) {
        return new CategoryDTO(category.getId(), category.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
