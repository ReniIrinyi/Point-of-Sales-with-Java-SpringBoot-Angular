package com.pos.api.service;

import com.pos.api.model.Product;
import com.pos.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, Long> {

    public ProductService(JpaRepository<Product, Long> repository) {
        super(repository);
    }
}
