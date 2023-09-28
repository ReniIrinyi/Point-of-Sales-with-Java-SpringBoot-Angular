package com.pos.api.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String productName;

    private double price;

    private double quantity;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    public Product() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSupplier(Supplier supplier) {
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