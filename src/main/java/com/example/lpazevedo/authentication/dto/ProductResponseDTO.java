package com.example.lpazevedo.authentication.dto;

import com.example.lpazevedo.authentication.model.product.Product;

public record ProductResponseDTO(String id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}