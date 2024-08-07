package com.example.pricing_engine.controllers;

import com.example.pricing_engine.models.Product;
import com.example.pricing_engine.repositories.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@NotNull @RequestBody Product newProduct) {

        List<Product> productOptional = productRepository.findByProductNameIgnoreCase(newProduct.getProductName());

        if(productOptional.isEmpty()){
            productRepository.save(newProduct);
            return new ResponseEntity<>("Product added successfully!", HttpStatus.CREATED);
        }

        for(Product product:productOptional){

            if(Objects.equals(product.getProductName(), newProduct.getProductName())){

                System.out.println("present");
                throw new RuntimeException();
            }
            else{
                productRepository.save(newProduct);
            }
        }

        return new ResponseEntity<>("Product added successfully!", HttpStatus.CREATED);

    }

}
