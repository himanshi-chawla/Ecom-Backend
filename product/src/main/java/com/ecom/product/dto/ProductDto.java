package com.ecom.product.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int quantity;
}
