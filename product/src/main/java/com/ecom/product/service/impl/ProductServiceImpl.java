package com.ecom.product.service.impl;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.entity.Product;
import com.ecom.product.entity.User;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        //get the list of all the products
        List<Product> resultList = productRepository.getAllProducts();
        List<ProductDto> productDtoList = mapProductEntityToDto(resultList);
        return productDtoList;
    }

    @Override
    public void addProduct(ProductDto productDto) {
        //converts product dto object to product entity object because we have to save it in database
        //in the form of a product entity's object
        Product product = mapProductDtoToEntity(productDto);
        //call a method from the product repository to save this product entity object in the database
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = mapProductDtoToEntity(productDto);
        productRepository.updateProduct(product);

    }

    private Product mapProductDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    private List<ProductDto> mapProductEntityToDto(List<Product> resultList) {
        List<ProductDto> result = new ArrayList<>();
        for(Product product : resultList){
            ProductDto productDto = new ProductDto(product.getId(), product.getName(),
                    product.getDescription(), product.getPrice(), product.getCategory(), product.getQuantity());
            result.add(productDto);
        }
        return result;
    }
}
