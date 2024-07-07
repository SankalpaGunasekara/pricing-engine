package com.example.pricing_engine.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String productName;
    private long price; //price of a single item
    private long cartonSize;
    private long cartonPrice; //single carton price

    public Product() {
    }

    public Product(long id, String productName, long price, long cartonSize, long cartonPrice) {

        this.id = id;
        this.productName = productName;
        this.price = price;
        this.cartonSize = cartonSize;
        this.cartonPrice = cartonPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public String getProductName() {

        return this.productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(long cartonSize) {
        this.cartonSize = cartonSize;
    }

    public long getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(long cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

}
