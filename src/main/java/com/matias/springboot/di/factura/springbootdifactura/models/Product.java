package com.matias.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;

public class Product {

    @Value("${config.product.name}")
    private String name;
    @Value("${config.product.price}")
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    
}
