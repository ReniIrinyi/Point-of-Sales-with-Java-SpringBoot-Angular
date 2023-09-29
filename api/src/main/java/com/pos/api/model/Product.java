package com.pos.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


@Entity
@Data
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private double price;

    private double quantity;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    private Category category;

    @OneToOne(cascade = CascadeType.MERGE)
    private Supplier supplier;

    public Product() {
    }

    @Override
    public Long getId(){
    return this.id;
    }

    public Product(long id, String productName, double price,
                   double quantity, String description, Category category, Supplier supplier) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.supplier = supplier;
    }

    public Product(String productName, double price,
                   double quantity, String description, Category category, Supplier supplier) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id +
                ", productName=" + productName +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description=" + description +
                ", category=" + category +
                ", supplier=" + supplier + '}';
    }
}