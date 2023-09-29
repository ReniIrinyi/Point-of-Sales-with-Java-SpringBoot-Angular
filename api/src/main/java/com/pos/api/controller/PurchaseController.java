package com.pos.api.controller;

import com.pos.api.model.Purchase;
import com.pos.api.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/purchases")
public class PurchaseController extends BaseRestController<Purchase, PurchaseRepository> {

    private final PurchaseRepository repository;

    public PurchaseController(PurchaseRepository repository) {
        this.repository = repository;
    }


    @Override
    protected PurchaseRepository getRepository() {
        return this.repository;
    }
}
