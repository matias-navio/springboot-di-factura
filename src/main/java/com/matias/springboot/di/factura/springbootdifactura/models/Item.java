package com.matias.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;

public class Item {

    private Product product;
    @Value("${config.item.quantity}")
    private Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getTotal(){
        return (int) (quantity * product.getPrice());
    }
}
