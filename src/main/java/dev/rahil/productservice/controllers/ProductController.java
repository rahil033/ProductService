package dev.rahil.productservice.controllers;

import dev.rahil.productservice.models.Product;
import dev.rahil.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("getProductById");
        Product product = productService.getSingleProduct(id);
        return product;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts");
        return productService.getAllProducts();
    }
}
