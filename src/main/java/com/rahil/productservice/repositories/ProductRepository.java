package com.rahil.productservice.repositories;

import com.rahil.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Product respository should contain all the CRUD operations to the product model
//    List<Product> findByPriceIsgreaterThan(double price);
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();
}

/*
1. Repository should be an interface
2. Repository should extend JpaRepository
 */