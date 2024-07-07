package com.example.pricing_engine.repositories;

import com.example.pricing_engine.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findProductByName(@Param("name") String name);
}