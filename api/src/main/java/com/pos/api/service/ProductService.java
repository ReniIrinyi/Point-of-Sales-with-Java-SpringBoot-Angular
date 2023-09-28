package com.pos.api.service;

import com.pos.api.model.Product;
import com.pos.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public void saveProduct(Product product){
        this.productRepository.save(product);
    }

    public void deleteProduct(Product product){
        this.productRepository.delete(product);
    }
}
