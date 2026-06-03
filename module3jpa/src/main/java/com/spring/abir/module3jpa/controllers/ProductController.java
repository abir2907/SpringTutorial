package com.spring.abir.module3jpa.controllers;

import com.spring.abir.module3jpa.entities.ProductEntity;
import com.spring.abir.module3jpa.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
        return productRepository.findAllBy(Sort.by(Sort.Direction.DESC, sortBy, "price", "quantity"));
    }
}
