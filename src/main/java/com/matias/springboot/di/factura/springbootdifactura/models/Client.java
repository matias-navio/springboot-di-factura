package com.matias.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
// se pone tambien a este porque si no se crean nuevas instancias del client y se concatena el nombre
@RequestScope
@JsonIgnoreProperties({"advisors", "targetSource"})
public class Client {

    @Value("${config.client.name}")
    private String name;
    @Value("${config.client.lastname}")
    private String lastName;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}
