package com.ecom.product.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int quantity;
}
