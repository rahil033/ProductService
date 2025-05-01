package com.rahil.productservice.services;

import com.rahil.productservice.exceptions.ProductNotFoundException;
import com.rahil.productservice.models.Category;
import com.rahil.productservice.models.Product;
import com.rahil.productservice.repositories.CategoryRepository;
import com.rahil.productservice.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to the Self Product API to fetch the Product with the given id
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }
        Product product = productOptional.get();
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int PageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(
                PageNumber, pageSize));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }
        Product productToUpdate = productOptional.get();
        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getPrice() != 0) {
            productToUpdate.setPrice(product.getPrice());
        }
        return productRepository.save(productToUpdate);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }
        Product productToUpdate = productOptional.get();
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCategory(product.getCategory());
        return productRepository.save(productToUpdate);
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
//        if (category.getId() == null) {
//
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }
        return productRepository.save(product);

    }
}
