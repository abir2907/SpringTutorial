package com.spring.abir.module3jpa;

import com.spring.abir.module3jpa.entities.ProductEntity;
import com.spring.abir.module3jpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Module3jpaApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
		/*
        List<ProductEntity> productEntityList = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2024,1,1,0,0,0,0)
		);
		*/

		// List<ProductEntity> productEntityList = productRepository.findByQuantityAndPrice(4, BigDecimal.valueOf(12.4));
		// List<ProductEntity> productEntityList = productRepository.findByQuantityGreaterThanAndPriceLessThan(3, BigDecimal.valueOf(14));
		// List<ProductEntity> productEntityList = productRepository.findByQuantityGreaterThanOrPriceLessThan(3, BigDecimal.valueOf(14));
		// List<ProductEntity> productEntityList = productRepository.findByTitleLike("p%");
		// List<ProductEntity> productEntityList = productRepository.findByTitleContaining("epsi");
		 List<ProductEntity> productEntityList = productRepository.findByTitleContainingIgnoreCase("EPSI");

		System.out.println(productEntityList);
	}

	@Test
	void getSingleFromRepository() {
		// We have defined a constraint on title and price, therefore we can be sure that each pair of title & price will be unique
		// Hence we can get a single entity instead of a List
		Optional<String> productEntity = productRepository.findByTitleAndPrice("Mazza", BigDecimal.valueOf(16.4));
		productEntity.ifPresent(System.out::println);
	}

}
