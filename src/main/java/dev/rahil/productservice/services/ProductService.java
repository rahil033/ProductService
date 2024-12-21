package dev.rahil.productservice.services;

import dev.rahil.productservice.exceptions.ProductNotFound;
import dev.rahil.productservice.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFound;
    List<Product> getAllProducts();
    Product createProduct(Long id, String title, String description, Double price, String category);
}
