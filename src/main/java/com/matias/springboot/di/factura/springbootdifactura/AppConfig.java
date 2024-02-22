package com.matias.springboot.di.factura.springbootdifactura;

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
    @Bean("tecnologi")
    List<Item> itemsInvoice(){

        return Arrays.asList(
            new Item(new Product("Camara SONY", 800d), 1),
            new Item(new Product("Notebook Lenovo", 1000d), 2)
        );
    }

    @Bean("office")
    List<Item> itemsInvoiceOffice(){

        return Arrays.asList(
            new Item(new Product("Escritorio Platinum", 300d), 3),
            new Item(new Product("Monitor SAMSUNG 24'", 1000d), 2),
            new Item(new Product("Impresona HP", 550d), 2),
            new Item(new Product("Mouse Genius", 50d), 4)
        );
    }
}
