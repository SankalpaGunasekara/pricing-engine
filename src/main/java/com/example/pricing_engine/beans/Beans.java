package com.example.pricing_engine.beans;

import com.example.pricing_engine.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Beans {

    @Bean

    public Product getProductClass() {

        return new Product();
    }
}
