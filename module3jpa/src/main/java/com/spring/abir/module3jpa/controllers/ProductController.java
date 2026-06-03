package com.spring.abir.module3jpa.controllers;

import com.spring.abir.module3jpa.entities.ProductEntity;
import com.spring.abir.module3jpa.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "title") String title,
                                              @RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber) {
        // return productRepository.findAllBy(Sort.by(Sort.Direction.DESC, sortBy, "price", "quantity"));
        /*
        return productRepository.findAllBy(Sort.by(
                Sort.Order.desc(sortBy),
                Sort.Order.asc("price")
        ));
        */


        Pageable pageable = PageRequest.of(
                pageNumber,
                PAGE_SIZE,
                Sort.by(sortBy));

        return productRepository.findByTitleContainingIgnoreCase(title, pageable);

        // return productRepository.findAll(pageable).getContent();

    }
}
