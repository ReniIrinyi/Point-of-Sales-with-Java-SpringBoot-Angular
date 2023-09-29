package com.pos.api.controller;

import com.pos.api.model.Supplier;
import com.pos.api.repository.SupplierRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/suppliers")
public class SupplierController extends BaseRestController<Supplier, SupplierRepository> {
    private final SupplierRepository repository;

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SupplierRepository getRepository() {
        return this.repository;
    }
}
