package com.example.pricing_engine.controllers;

import com.example.pricing_engine.models.Product;
import com.example.pricing_engine.repositories.ProductRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
    public void addProduct(@RequestBody Product newProduct) {

        List<Product> productOptional = productRepository.findByProductNameIgnoreCase(newProduct.getProductName());

        if(productOptional.isEmpty()){
            productRepository.save(newProduct);
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
//


    }

}
