package com.spring.abir.module3jpa.repositories;

import com.spring.abir.module3jpa.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(Integer quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(Integer quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    // Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e.title from ProductEntity e where e.title = :title and e.price = :price")
    Optional<String> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findAllBy(Sort sort);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
