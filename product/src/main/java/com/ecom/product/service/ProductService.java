package com.ecom.product.service;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();
    void addProduct(ProductDto productDto);
    void updateProduct(ProductDto productDto);
}
