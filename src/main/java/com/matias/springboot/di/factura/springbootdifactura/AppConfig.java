package com.matias.springboot.di.factura.springbootdifactura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.matias.springboot.di.factura.springbootdifactura.models.Item;
import com.matias.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
})
public class AppConfig {

    // lo que devulve este metodo se guarda como componente de spring
    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara SONY", 800d);
        Product p2 = new Product("Notebook Lenovo", 1500d);
        Product p3 = new Product("Playstation 5", 1300d);

        return Arrays.asList(
            new Item(p1, 1),
            new Item(p2, 2),
            new Item(p3, 1)
        );
    }
}
