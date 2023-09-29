package com.pos.api.controller;

import com.pos.api.model.Invoice;
import com.pos.api.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/invoices")
public class InvoiceController extends BaseRestController<Invoice, InvoiceRepository> {

    private final InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    protected InvoiceRepository getRepository() {
        return this.repository;
    }
}
