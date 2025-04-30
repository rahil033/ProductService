package com.rahil.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private double price;
    private String title;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}
