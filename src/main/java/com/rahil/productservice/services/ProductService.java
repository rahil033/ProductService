package com.rahil.productservice.services;

import com.rahil.productservice.exceptions.ProductNotFoundException;
import com.rahil.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Page<Product> getAllProducts(int PageNumber, int pageSize);
    void deleteProduct(Long productId);
    Product updateProduct(Long productId, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long productId, Product product) throws ProductNotFoundException;
    Product createProduct(Product product);
}
