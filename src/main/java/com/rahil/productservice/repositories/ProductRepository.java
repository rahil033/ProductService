package com.rahil.productservice.repositories;

import com.rahil.productservice.models.Product;
import com.rahil.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Product respository should contain all the CRUD operations to the product model
//    List<Product> findByPriceIsgreaterThan(double price);
    Optional<Product> findById(Long id);

    @Override
    Page<Product> findAll(Pageable pageable);

    // HQL custom query
    @Query("SELECT p.id as id, p.title as title from Product p where p.id = :x")
    List<ProductWithIdAndTitle> randomMethod(Long x);
}

/*
1. Repository should be an interface
2. Repository should extend JpaRepository
 */