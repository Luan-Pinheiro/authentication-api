package com.example.lpazevedo.authentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lpazevedo.authentication.dto.ProductRequestDTO;
import com.example.lpazevedo.authentication.dto.ProductResponseDTO;
import com.example.lpazevedo.authentication.model.product.Product;
import com.example.lpazevedo.authentication.repositories.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("products")
public class ProductController {
  @Autowired
  ProductRepository productRepository;

  @PostMapping
  public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body) {
    Product product = new Product(body);

    this.productRepository.save(product);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity getProducts() {
    List<ProductResponseDTO> products = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
  
    return ResponseEntity.ok(products);
  }
}
