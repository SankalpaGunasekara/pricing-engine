package com.example.pricing_engine.controllers;

import com.example.pricing_engine.models.Product;
import com.example.pricing_engine.repositories.ProductRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/v1/api/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController( ProductRepository productRepository){

        this.productRepository = productRepository;

    }

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){

//        Optional <Product> productOptional =
            return product;
    }

}
