package com.pos.api.controller;

import com.pos.api.model.Sale;
import com.pos.api.repository.SaleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sales")
public class SaleController extends BaseRestController<Sale, SaleRepository> {

    private final SaleRepository repository;

    public SaleController(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SaleRepository getRepository() {
        return this.repository;
    }
}
