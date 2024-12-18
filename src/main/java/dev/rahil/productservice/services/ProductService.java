package dev.rahil.productservice.services;

import dev.rahil.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
}
