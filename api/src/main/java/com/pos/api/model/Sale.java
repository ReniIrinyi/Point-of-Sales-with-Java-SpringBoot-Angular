package com.pos.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sale extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Invoice invoice;

    @OneToOne(cascade = CascadeType.MERGE)
    private Product product;

    private double quantity;

    private double price;

    private double total;
    @Column( insertable=false)
    private String date;

    public void Sale() {
    }

    public void Sale(Invoice invoice, Product product, double quantity, double price, double total) {
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id +
                ", invoice=" + invoice +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                ", date=" + date + '}';
    }
    @Override
    public Long getId() {
        return this.id;
    }

}
