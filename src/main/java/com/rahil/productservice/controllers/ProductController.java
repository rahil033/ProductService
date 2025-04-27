package com.rahil.productservice.controllers;

import com.rahil.productservice.exceptions.ProductNotFoundException;
import com.rahil.productservice.models.Product;
import com.rahil.productservice.services.FakeStoreProductService;
import com.rahil.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
//        ResponseEntity<Product> responseEntity = null;
//
//        try {
//            Product product = productService.getSingleProduct(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK);

        return responseEntity;
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
