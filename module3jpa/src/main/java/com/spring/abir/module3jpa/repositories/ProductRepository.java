package com.spring.abir.module3jpa.repositories;

import com.spring.abir.module3jpa.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
