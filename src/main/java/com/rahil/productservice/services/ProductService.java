package com.rahil.productservice.services;

import com.rahil.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
}
