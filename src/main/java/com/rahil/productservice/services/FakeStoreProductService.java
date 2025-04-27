package com.rahil.productservice.services;

import com.rahil.productservice.dtos.FakeStoreProductDto;
import com.rahil.productservice.models.Category;
import com.rahil.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //Call FakeStore to fetch the Product with the given id
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
        //Convert FakeStoreProductDto into Product
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtoList = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        // Convert List of FakeStoreProductDto into List of Product
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        product.setCategory(category);
        category.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }
}
