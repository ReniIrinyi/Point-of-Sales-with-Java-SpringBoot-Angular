package com.pos.api.controller;

import com.pos.api.model.Product;
import com.pos.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProduktController extends BaseRestController<Product, ProductRepository> {

    @Autowired
    private final ProductRepository repository;

    public ProduktController(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ProductRepository getRepository() {
        return this.repository;
    }
}
