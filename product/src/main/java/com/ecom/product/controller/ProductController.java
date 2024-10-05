package com.ecom.product.controller;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.entity.Product;
import com.ecom.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //create API for get all products
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //create API for add product
    @PostMapping("/save")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
        return new ResponseEntity<>("Product added successfully!",HttpStatus.CREATED);
    }

    //create API for modify product
    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
        return new ResponseEntity<>("Update successful!!", HttpStatus.OK);
    }



}
