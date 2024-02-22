package com.matias.springboot.di.factura.springbootdifactura.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.springboot.di.factura.springbootdifactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/view")
    public Invoice view(){

        return invoice;
    }
}
