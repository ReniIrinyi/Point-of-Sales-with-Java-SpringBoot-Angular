package com.pos.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private double unitPrice;
    private double quantity;
    private double total;
    @Override
    public Long getId() {
        return this.id;
    }
    public Item() {
    }

    public Item(String itemName, double unitPrice, double quantity, double total) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", total=" + total + '}';
    }
}
