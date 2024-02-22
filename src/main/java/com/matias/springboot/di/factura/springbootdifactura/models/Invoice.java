package com.matias.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// define el alcance de un bean, se debe crear una instancia en cada rquest HTTP, se limita el ciclo de vida 
@RequestScope
@JsonIgnoreProperties({"advisors", "targetSource"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${config.invoice.description.cosas}")
    private String description;

    @Autowired
    @Qualifier("office")
    private List<Item> items;

    // esta anotación sirve para manipular los datos despues de instanciarlos en el constructor
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Rodriguez"));
        System.out.println(client.getName());
        description = description.concat(" del cliente: " ).concat(client.getName());
    }

    // esto se ejecuta en el momento en el que el componente se destruye
    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente factura!");
    }

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
