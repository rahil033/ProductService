package com.rahil.productservice.controllers;

import com.rahil.productservice.models.Product;
import com.rahil.productservice.services.FakeStoreProductService;
import com.rahil.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService ;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

}
