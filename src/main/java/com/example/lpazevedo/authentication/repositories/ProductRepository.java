package com.example.lpazevedo.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lpazevedo.authentication.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
  
}
