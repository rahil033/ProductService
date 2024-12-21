package dev.rahil.productservice.controllers;

import dev.rahil.productservice.exceptions.ProductNotFound;
import dev.rahil.productservice.models.Product;
import dev.rahil.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFound {
        System.out.println("getProductById");
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return responseEntity;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts");
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product.getId(),
                product.getTitle(), product.getDescripion(), product.getPrice(),
                product.getCategory().getTitle());
        return p;
    }
}
