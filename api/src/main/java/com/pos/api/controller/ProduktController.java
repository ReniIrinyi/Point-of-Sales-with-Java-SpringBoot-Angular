package com.pos.api.controller;

import com.pos.api.model.Product;
import com.pos.api.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProduktController {

    @Autowired
    private final ProductService productService;

    public ProduktController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @RequestMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return ResponseEntity.ok("Product:"+product.getProductName()+" is deleted");
    }
}
