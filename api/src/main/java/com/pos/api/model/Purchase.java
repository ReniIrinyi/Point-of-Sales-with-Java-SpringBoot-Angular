package com.pos.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Purchase extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private Product product;
    @OneToOne(cascade = CascadeType.MERGE)
    private Supplier supplier;
    private double quantity;
    private double price;
    private double total;
    @Column( insertable=false)
    private String date;

    public Purchase() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public Purchase(Product product, Supplier supplier,
                    double quantity, double price, double total) {
        this.product = product;
        this.supplier = supplier;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id +
                ", product=" + product +
                ", supplier=" + supplier +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                ", date=" + date + '}';
    }
}
