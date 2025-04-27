package com.rahil.productservice.services;

import com.rahil.productservice.exceptions.ProductNotFoundException;
import com.rahil.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    void deleteProduct(Long productId);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    Product createProduct(Product product);
}
