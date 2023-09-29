package com.pos.api.controller;

import com.pos.api.model.Payment;
import com.pos.api.repository.PaymentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/payments")
public class PaymentController extends BaseRestController<Payment, PaymentRepository> {
    private final PaymentRepository repository;

    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected PaymentRepository getRepository() {
        return this.repository;
    }
}
