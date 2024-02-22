package com.matias.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

    @Autowired
    private Client client;

    @Value("${config.invoice.description}")
    private String description;

    @Autowired
    private List<Item> items;

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getImporte(){
        // dos maneras distintas de sumar el total de cada item de la factura
        // primero con la api stream() y el metodo reduce y despues con un simple for
        return items.stream().
        map(item -> item.getTotal()).
        reduce(0, (sum, item) -> sum + item);

        // Integer result = 0;
        // for(Item item : items){
        //     result += item.getTotal();
        // }
        // return result;
    }
}
